package com.ktorium.expekto

import kotlin.test.Test

class ExpektoTest {
    @Test
    fun singleSubjectReturnsSuccessful() {
        expectThat(3)
    }

    @Test
    fun singleNullableSubjectReturnsSuccess() {
        val value: String? = null

        expectThatNotNull(value)
    }

    @Test
    fun singleSubjectWithEmptyAssertionBlockReturnsSuccess() {
        expectThat(3) {
        }
    }
}
