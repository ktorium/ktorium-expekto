package com.ktorium.expekto

import kotlin.test.Test

class ExpektoTest {
    @Test
    fun singleSubjectReturnsSuccessful() {
        expectThat(3)
    }

    @Test
    fun singleNullableSubjectReturnsSuccessful() {
        val value: String? = null

        expectThatNotNull(value)
    }

    @Test
    fun singleSubjectWithEmptyAssertionBlockReturnsSuccessful() {
        expectThat(3) {
        }
    }
}
