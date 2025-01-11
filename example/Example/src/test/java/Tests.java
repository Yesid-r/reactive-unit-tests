import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class Tests {

    @Test
    void showMessageMethodShouldReturnOneValue() {
        StepVerifier.create(Examples.showMessage())
                .expectNextCount(1)
                .verifyComplete();

    }

    @Test
    void showMessageMethodShouldStartWithLetterE() {

        StepVerifier.create(Examples.showMessage())
                .expectNextMatches(message -> message.startsWith("E"))
                .verifyComplete();
    }

    @Test
    void customersNameByIdShouldReturnCarlosIfIdIs2() {
        StepVerifier.create(Examples.customersNameById("2"))
                .expectNext("Carlos")
                .verifyComplete();
    }

    @Test
    void customersNameByIdShouldReturnEmptyIfIdIsAbove3() {
        StepVerifier.create(Examples.customersNameById("4"))
                .verifyComplete();
    }

    @Test
    void upperCaseMessageShouldReturnError() {
        StepVerifier.create(Examples.upperCaseMessage())
                .expectNext("NO")
                .expectError()
                .verify();

    }

    @Test
    void upperCaseMessageShouldReturnNullPointerException() {

        StepVerifier.create(Examples.upperCaseMessage())
                .expectNext("NO")
                .expectError(NullPointerException.class)
                .verify();
    }
}
