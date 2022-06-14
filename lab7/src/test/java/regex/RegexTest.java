package regex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegexTest {
    Regex regex = new Regex();


    @BeforeEach
    void setUp() throws Exception {
        Regex regex = new Regex();
    }

    @Test
    void replaceData() {
        String expected = " (replaced) tuirbvrbvchbrudvlrenvbr,hv vnuvtn fhrufn (replaced) fhrufrufhurhfurhfurhufhrufh rt-hg $ fjrfnrjnfjrf (replaced) $hutf-rg$hutf-rg$hutf-rg $hutf-rg";
        Assertions.assertEquals(expected, regex.replaceData());
    }
}