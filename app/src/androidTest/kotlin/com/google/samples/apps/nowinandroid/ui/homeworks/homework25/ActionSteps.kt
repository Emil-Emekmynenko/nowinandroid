package com.google.samples.apps.nowinandroid.ui.homeworks.homework25

import androidx.lifecycle.AtomicReference
import io.github.kakaocup.compose.node.action.NodeActions
import java.util.concurrent.Executor

class ActionSteps(private val stepsExecutor: StepsExecutor) : StepsDSL<ActionSteps>() {
    override val self: ActionSteps = this

    fun click(item: NodeActions) {
        stepsExecutor.click(
            "Нажимает на кнопку ${item.name()}",
            item
        )
    }

    fun <T> extract(
        item: NodeActions,
        container: AtomicReference<T>,
        extraction: (item: NodeActions) -> T,
    ){
        stepsExecutor.extractSemantic(
            "Получает данные из элемента '${item.name()}'",
            item,
            container,
            extraction
        )
    }

    fun nextStep(step: String) = stepsExecutor.setNextStepName(step)
}