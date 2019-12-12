package action

import com.intellij.notification.NotificationDisplayType
import com.intellij.notification.NotificationGroup
import com.intellij.notification.NotificationType
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.LangDataKeys
import com.intellij.openapi.actionSystem.PlatformDataKeys
import helper.KtClassHelper
import org.jetbrains.kotlin.com.intellij.psi.PsiClass
import org.jetbrains.kotlin.com.intellij.psi.PsiElement
import org.jetbrains.kotlin.idea.internal.Location
import org.jetbrains.kotlin.psi.KtClass


class MyAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val noti = NotificationGroup("myplugin", NotificationDisplayType.BALLOON, true)
        noti.createNotification("My Title",
            KtClassHelper.findParamsPrototype(getPsiClassFromEvent(e)!!).toString(),
            NotificationType.INFORMATION,
            null
        ).notify(e.project)
    }

    private fun getPsiClassFromEvent(e: AnActionEvent): KtClass? {
        val psiElement = e.getData(
            LangDataKeys.PSI_ELEMENT
        ) ?: return null

        return psiElement as KtClass
    }
}