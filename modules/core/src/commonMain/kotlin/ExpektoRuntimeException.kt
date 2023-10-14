package com.ktorium.expekto

public open class ExpektoRuntimeException(
    message: String? = null,
    cause: Throwable? = null
) : RuntimeException(message, cause)
