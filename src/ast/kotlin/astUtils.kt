package ts2kt.kotlin.ast

import ts2kt.escapeIfNeed
import ts2kt.utils.join

fun <T> List<T>.stringify() = join("\n", endWithIfNotEmpty = "\n")

fun Annotation.getFirstParamAsString(): String? {
    if (this.parameters.isEmpty()) return null

    val annotationParam = this.parameters[0].value as String
    return annotationParam.substring(1, annotationParam.size - 1)
}

fun Classifier.isModule() = kind === ClassKind.OBJECT && hasModuleAnnotation()

fun Classifier.hasModuleAnnotation() = annotations.any { it.name == MODULE }

fun Classifier.getClassObject(): Classifier? =
        this.members.firstOrNull { it is Classifier && it.kind === ClassKind.COMPANION_OBJECT } as? Classifier

val Named.escapedName: String
    get() = name.escapeIfNeed()
