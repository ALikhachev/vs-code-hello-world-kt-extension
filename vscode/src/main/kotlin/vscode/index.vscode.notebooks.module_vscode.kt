@file:JsModule("vscode")
@file:JsNonModule@file:JsQualifier("notebooks")
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package vscode.notebooks

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
import vscode.NotebookCell
import vscode.NotebookDocument
import vscode.NotebookController
import vscode.NotebookCellStatusBarItemProvider
import vscode.Disposable
import vscode.NotebookRendererMessaging

external fun createNotebookController(id: String, notebookType: String, label: String, handler: (cells: Array<NotebookCell>, notebook: NotebookDocument, controller: NotebookController) -> Any = definedExternally): NotebookController

external fun registerNotebookCellStatusBarItemProvider(notebookType: String, provider: NotebookCellStatusBarItemProvider): Disposable

external fun createRendererMessaging(rendererId: String): NotebookRendererMessaging