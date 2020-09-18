package com.kodluyoruz.tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;


public class WordCounterTest{
    @Test
    public void countUniqueWord_WhenStringIsNull_ItShouldGiveException() {
        //Arrange
        WordCounter sut = new WordCounter();

        //Act
        Throwable throwable = catchThrowable(() ->  sut.countUniqueWord(null));

        //Assert
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class).hasMessage("Sentence can not be null!");
    }


}
