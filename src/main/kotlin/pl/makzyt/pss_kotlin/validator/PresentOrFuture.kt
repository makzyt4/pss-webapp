package pl.makzyt.pss_kotlin.validator

import java.lang.annotation.Documented
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [PresentOrFutureValidator::class])
@Documented
annotation class PresentOrFuture(val message:String = "{PresentOrFuture.message}",
                                 val groups:Array<KClass<*>> = [],
                                 val payload:Array<KClass<out Payload>> = [])