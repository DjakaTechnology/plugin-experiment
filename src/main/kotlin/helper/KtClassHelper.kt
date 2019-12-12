package helper

import org.jetbrains.kotlin.asJava.elements.KtLightElement
import org.jetbrains.kotlin.com.intellij.psi.PsiElement
import org.jetbrains.kotlin.descriptors.ValueParameterDescriptor
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.KtElement
import java.util.*

object KtClassHelper {
    fun findParams(ktClass: KtClass): List<ValueParameterDescriptor> {
        val list = ArrayList<KtElement>()
        list.add(ktClass)

        return listOf()
    }

    fun findParamsPrototype(ktClass: KtClass): Int {
        val list = ArrayList<KtElement>()
        list.add(ktClass)

        return ktClass.getProperties().count()
    }

    fun getKtClassForElement(psiElement: PsiElement): KtClass? {
        if (psiElement is KtLightElement<*, *>) {
            val origin: PsiElement? = psiElement.kotlinOrigin as PsiElement
            println("PSI CLASS IS KtLightElement")
            return if (origin != null) {
                getKtClassForElement(origin)
            } else {
                null
            }
        } else {
            println("PSI IS NOT KtLightElement")
            (psiElement as KtClass)?.let {
                println("PSI CLASS IS KtClass")
                return it
            }
        }
    }
}