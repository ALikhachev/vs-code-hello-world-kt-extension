@file:JsModule("vscode")
@file:JsNonModule
@file:JsQualifier("tasks")
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package vscode.tasks

import kotlin.js.*
import org.khronos.webgl.*
import org.w3c.dom.*
import org.w3c.dom.events.*
import org.w3c.dom.parsing.*
import org.w3c.dom.svg.*
import org.w3c.dom.url.*
import org.w3c.fetch.*
import org.w3c.files.*
import org.w3c.notifications.*
import org.w3c.performance.*
import org.w3c.workers.*
import org.w3c.xhr.*
import vscode.TaskProvider__0
import vscode.Disposable
import vscode.TaskFilter
import Thenable
import vscode.Task
import vscode.TaskExecution
import vscode.Event
import vscode.TaskStartEvent
import vscode.TaskEndEvent
import vscode.TaskProcessStartEvent
import vscode.TaskProcessEndEvent

external fun registerTaskProvider(type: String, provider: TaskProvider__0): Disposable

external fun fetchTasks(filter: TaskFilter = definedExternally): Thenable<Array<Task>>

external fun executeTask(task: Task): Thenable<TaskExecution>

external var taskExecutions: Array<TaskExecution>

external var onDidStartTask: Event<TaskStartEvent>

external var onDidEndTask: Event<TaskEndEvent>

external var onDidStartTaskProcess: Event<TaskProcessStartEvent>

external var onDidEndTaskProcess: Event<TaskProcessEndEvent>