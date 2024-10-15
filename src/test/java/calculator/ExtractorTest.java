package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ExtractorTest {

    @ParameterizedTest
    @CsvSource(value = {"'//;\n1;2;3'","'1,2:3'"})
    @DisplayName("계산에 필요한 숫자들을 추출한다.")
    void extractNumbers(String input) {
        // given
        System.out.println(input);
        Extractor extractor = new Extractor(input);

        // when
        List<Integer> numbers = extractor.extractNumbers();

        // then
        assertThat(numbers).containsExactly(1, 2, 3);
    }

    @ParameterizedTest
    @CsvSource({"'//;\nA;2;3'","'-1,2:3'"})
    @DisplayName("계산에 필요한 숫자들을 추출한다. 숫자가 아니거나 음수이면 에외를 발생시킨다.")
    void extractNumbersWithException(String input) {
        // given
        Extractor extractor = new Extractor(input);

        // when

        // then
        assertThatThrownBy(extractor::extractNumbers)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("커스텀 구분자를 추출한다.")
    void extractDelimiter() {
        // given
        String input = "//;\n1;2;3";
        Extractor extractor = new Extractor(input);

        // when
        String delimiter = extractor.extractDelimiter();

        // then
        assertThat(delimiter).isEqualTo(";");
    }

    @Test
    @DisplayName("커스텀 구분자가 없으면 기본 구분자를 반환한다.")
    void extractDelimiterNotFound() {
        // given
        String input = "1,2:3";
        Extractor extractor = new Extractor(input);

        // when
        String delimiter = extractor.extractDelimiter();

        // then
        assertThat(delimiter).isEqualTo(",|:");
    }
}