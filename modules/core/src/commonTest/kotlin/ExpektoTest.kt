package com.ktorium.expekto

import com.ktorium.expekto.assertions.isEqualTo
import com.ktorium.expekto.assertions.isNotEqualTo
import kotlin.test.Test

class ExpektoTest {
    @Test
    fun test1() {
        expectThat(3).isEqualTo(3).isNotEqualTo(4)

        expectThat(3){
            isEqualTo(3)
            isNotEqualTo(4).isEqualTo(3)
        }
    }
}
