package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"'//;\n1;2;3'","'1,2:3'"})
    @DisplayName("문자열 계산기를 실행해 합계를 얻는다.")
    void splitAndSum(String input) {
        // given

        // when
        int sum = Calculator.splitAndSum(input);

        // then
        assertThat(sum).isEqualTo(6);
    }

    @ParameterizedTest
    @CsvSource(value = {"NULL","''"}, nullValues = "NULL")
    @DisplayName("문자열 계산기를 실행해 합계를 얻는다. null이나 빈문자열일 경우 0을 반환한다")
    void splitAndSumWithBlank(String input) {
        // given

        // when
        int sum = Calculator.splitAndSum(input);

        // then
        assertThat(sum).isEqualTo(0);
    }

    @Test
    @DisplayName("수의 합계를 도출한다")
    void getSum() {
        // given
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // when
        int sum = Calculator.getSum(list);

        // then
        assertThat(sum).isEqualTo(6);
    }
}