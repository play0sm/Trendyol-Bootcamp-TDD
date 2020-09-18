package com.kodluyoruz.tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;


public class WordCounterTest{
    @Test
    public void countUniqueWord_WhenSentenceIsNull_ShouldThrowIllegalArgumentException() {
        //Arrange
        WordCounter sut = new WordCounter();

        //Act
        Throwable throwable = catchThrowable(() ->  sut.countUniqueWord(null));

        //Assert
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class).hasMessage("Sentence can not be null!");
    }

    @Test
    public void countUniqueWord_WhenSentenceIsEmpty_ShouldReturnZero() {
        //Arrange
        WordCounter sut = new WordCounter();

        //Act
        int result = sut.countUniqueWord("");

        //Assert
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void countUniqueWord_WhenSentenceIsNotSameWord_ItShouldFour() {
        //Arrange
        WordCounter sut = new WordCounter();

        //Act
        int result = sut.countUniqueWord("this is a test");

        //Assert
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void countUniqueWord_WhenSentenceHasDuplicateWord_ItShouldReturnTwo() {
        //Arrange
        WordCounter sut = new WordCounter();

        //Act
        int result = sut.countUniqueWord("as much as");

        //Assert
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void countUniqueWord_WhenSentenceHasUpperCaseWord_ItShouldReturnThree() {
        //Arrange
        WordCounter sut = new WordCounter();

        //Act
        int result = sut.countUniqueWord("As much as");

        //Assert
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void countUniqueWord_WhenSentenceHasDot_ItShouldReturnFour() {
        //Arrange
        WordCounter sut = new WordCounter();

        //Act
        int result = sut.countUniqueWord("This is a test.");

        //Assert
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void countUniqueWord_WhenSentenceHasComma_ItShouldReturnFour() {
        //Arrange
        WordCounter sut = new WordCounter();

        //Act
        int result = sut.countUniqueWord("Apple, orange and melon.");

        //Assert
        assertThat(result).isEqualTo(4);
    }

    /*
        The character/characters that come after apostrophe represent a word.
        Example: is, are, am, have, will, not etc.
        These characters count as a word.
        NOTE: This test not cover "s", which is the ownership suffix.
     */
    @Test
    public void countUniqueWord_WhenSentenceHasApostrophe_ItShouldReturnFour() {
        //Arrange
        WordCounter sut = new WordCounter();

        //Act
        int result = sut.countUniqueWord("This's a test.");

        //Assert
        assertThat(result).isEqualTo(4);
    }

}
