package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void requirement01(){
        String s1 = "1,2";
        String[] splitS1 = s1.split(",");
        assertThat(splitS1).contains("1", "2");

        String s2 = "1";
        String[] splitS2 = s2.split(",");
        assertThat(splitS2).containsExactly("1");
    }

    @Test
    void requirement02(){
        String s = "(1,2)";
        String substring = s.substring(1, 4);
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsException 처리에 대한 테스트")
    void requirement03() {
        String s = "abc";

        char c = s.charAt(1);

        assertThat(c).isEqualTo('b');
        assertThatThrownBy(()->s.charAt(5))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
