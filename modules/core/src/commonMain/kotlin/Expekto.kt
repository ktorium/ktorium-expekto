package com.ktorium.expekto

public class Expekto

public fun <T : Any> expectThat(subject: T): Expekto {
    return Expekto()
}

public fun <T : Any> expectThat(subject: T, block: Expekto.() -> Unit): Expekto {
    return Expekto()
}

public fun <T : Any> expectThatNotNull(subject: T?): Expekto {
    return Expekto()
}
