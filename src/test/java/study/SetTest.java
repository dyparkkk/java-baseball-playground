package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void req01_set의사이즈Test(){
        int n = 3;

        assertThat(numbers.size()).isEqualTo(n);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void req02_set_containsTest(int num){
        assertThat(numbers.contains(num)).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"1,true", "2,true","3,true", "4,false","5,false"})
    void req03_setInputAndExpectedTest(String input, String expected) {
        Integer integer = Integer.valueOf(input);
        Boolean expectedBool = Boolean.valueOf(expected);

        assertEquals(numbers.contains(integer), expectedBool);
    }
}
