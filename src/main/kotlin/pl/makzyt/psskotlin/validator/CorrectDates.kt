package pl.makzyt.psskotlin.validator

import java.lang.annotation.Documented
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD, AnnotationTarget.FUNCTION, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [CorrectDatesValidator::class])
@Documented
annotation class CorrectDates(val message:String = "{CorrectDates.message}",
                              val groups:Array<KClass<*>> = [],
                              val payload:Array<KClass<out Payload>> = [])