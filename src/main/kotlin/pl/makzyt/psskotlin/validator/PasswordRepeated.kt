package pl.makzyt.psskotlin.validator

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD, AnnotationTarget.FUNCTION, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [PasswordRepeatedValidator::class])
@MustBeDocumented
annotation class PasswordRepeated(val message:String = "{PasswordRepeted.message}",
                                  val groups:Array<KClass<*>> = [],
                                  val payload:Array<KClass<out Payload>> = [])