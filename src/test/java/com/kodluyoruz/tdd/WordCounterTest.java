package com.kodluyoruz.tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;


public class WordCounterTest{
    @Test
    public void countUniqueWord_WhenStringIsNull_ShouldThrowIllegalArgumentException() {
        //Arrange
        WordCounter sut = new WordCounter();

        //Act
        Throwable throwable = catchThrowable(() ->  sut.countUniqueWord(null));

        //Assert
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class).hasMessage("Sentence can not be null!");
    }

    @Test
    public void countUniqueWord_WhenStringIsNotSameWord_ItShouldFour() {
        //Arrange
        WordCounter sut = new WordCounter();

        //Act
        int result = sut.countUniqueWord("this is a test");

        //Assert
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void countUniqueWord_WhenStringHasDuplicateWord_ItShouldReturnTwo() {
        //Arrange
        WordCounter sut = new WordCounter();

        //Act
        int result = sut.countUniqueWord("as much as");

        //Assert
        assertThat(result).isEqualTo(2);
    }

}
