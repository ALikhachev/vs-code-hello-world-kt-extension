@file:JsModule("vscode")
@file:JsNonModule
@file:JsQualifier("window")
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package vscode.window

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
import vscode.TextEditor
import vscode.Event
import vscode.TextEditorSelectionChangeEvent
import vscode.TextEditorVisibleRangesChangeEvent
import vscode.TextEditorOptionsChangeEvent
import vscode.TextEditorViewColumnChangeEvent
import vscode.Terminal
import vscode.WindowState
import vscode.TextDocument
import vscode.ViewColumn
import Thenable
import vscode.TextDocumentShowOptions
import vscode.Uri
import vscode.DecorationRenderOptions
import vscode.TextEditorDecorationType
import vscode.MessageOptions
import vscode.MessageItem
import vscode.QuickPickOptions
import vscode.CancellationToken
import vscode.QuickPickItem
import vscode.WorkspaceFolderPickOptions
import vscode.WorkspaceFolder
import vscode.OpenDialogOptions
import vscode.SaveDialogOptions
import vscode.InputBoxOptions
import vscode.QuickPick
import vscode.InputBox
import vscode.OutputChannel
import vscode.WebviewPanelOptions
import vscode.WebviewPanel
import vscode.Disposable
import vscode.Progress
import vscode.ProgressOptions
import vscode.StatusBarAlignment
import vscode.StatusBarItem
import vscode.TerminalOptions
import vscode.ExtensionTerminalOptions
import vscode.TreeDataProvider
import vscode.TreeViewOptions
import vscode.TreeView
import vscode.UriHandler
import vscode.WebviewPanelSerializer__0
import vscode.WebviewViewProvider
import vscode.CustomTextEditorProvider
import vscode.CustomReadonlyEditorProvider__0
import vscode.CustomEditorProvider__0
import vscode.TerminalLinkProvider__0
import vscode.TerminalProfileProvider
import vscode.FileDecorationProvider
import vscode.ColorTheme

external var activeTextEditor: TextEditor?

external var visibleTextEditors: Array<TextEditor>

external var onDidChangeActiveTextEditor: Event<TextEditor?>

external var onDidChangeVisibleTextEditors: Event<Array<TextEditor>>

external var onDidChangeTextEditorSelection: Event<TextEditorSelectionChangeEvent>

external var onDidChangeTextEditorVisibleRanges: Event<TextEditorVisibleRangesChangeEvent>

external var onDidChangeTextEditorOptions: Event<TextEditorOptionsChangeEvent>

external var onDidChangeTextEditorViewColumn: Event<TextEditorViewColumnChangeEvent>

external var terminals: Array<Terminal>

external var activeTerminal: Terminal?

external var onDidChangeActiveTerminal: Event<Terminal?>

external var onDidOpenTerminal: Event<Terminal>

external var onDidCloseTerminal: Event<Terminal>

external var state: WindowState

external var onDidChangeWindowState: Event<WindowState>

external fun showTextDocument(document: TextDocument, column: ViewColumn = definedExternally, preserveFocus: Boolean = definedExternally): Thenable<TextEditor>

external fun showTextDocument(document: TextDocument): Thenable<TextEditor>

external fun showTextDocument(document: TextDocument, column: ViewColumn = definedExternally): Thenable<TextEditor>

external fun showTextDocument(document: TextDocument, options: TextDocumentShowOptions = definedExternally): Thenable<TextEditor>

external fun showTextDocument(uri: Uri, options: TextDocumentShowOptions = definedExternally): Thenable<TextEditor>

external fun showTextDocument(uri: Uri): Thenable<TextEditor>

external fun createTextEditorDecorationType(options: DecorationRenderOptions): TextEditorDecorationType

external fun showInformationMessage(message: String, vararg items: String): Thenable<String?>

external fun showInformationMessage(message: String, options: MessageOptions, vararg items: String): Thenable<String?>

external fun <T : MessageItem> showInformationMessage(message: String, vararg items: T): Thenable<T?>

external fun <T : MessageItem> showInformationMessage(message: String, options: MessageOptions, vararg items: T): Thenable<T?>

external fun showWarningMessage(message: String, vararg items: String): Thenable<String?>

external fun showWarningMessage(message: String, options: MessageOptions, vararg items: String): Thenable<String?>

external fun <T : MessageItem> showWarningMessage(message: String, vararg items: T): Thenable<T?>

external fun <T : MessageItem> showWarningMessage(message: String, options: MessageOptions, vararg items: T): Thenable<T?>

external fun showErrorMessage(message: String, vararg items: String): Thenable<String?>

external fun showErrorMessage(message: String, options: MessageOptions, vararg items: String): Thenable<String?>

external fun <T : MessageItem> showErrorMessage(message: String, vararg items: T): Thenable<T?>

external fun <T : MessageItem> showErrorMessage(message: String, options: MessageOptions, vararg items: T): Thenable<T?>

external interface `T$34` {
    var canPickMany: Boolean
}

external fun showQuickPick(items: Array<String>, options: QuickPickOptions /* QuickPickOptions & `T$34` */, token: CancellationToken = definedExternally): dynamic /* Thenable | Thenable */

external fun showQuickPick(items: Array<String>, options: QuickPickOptions /* QuickPickOptions & `T$34` */): dynamic /* Thenable | Thenable */

external fun showQuickPick(items: Thenable<Array<String>>, options: QuickPickOptions /* QuickPickOptions & `T$34` */, token: CancellationToken = definedExternally): dynamic /* Thenable | Thenable */

external fun showQuickPick(items: Thenable<Array<String>>, options: QuickPickOptions /* QuickPickOptions & `T$34` */): dynamic /* Thenable | Thenable */

external fun showQuickPick(items: Array<String>): Thenable<String?>

external fun showQuickPick(items: Thenable<Array<String>>): Thenable<String?>

external fun <T : QuickPickItem> showQuickPick(items: Array<T>, options: QuickPickOptions /* QuickPickOptions & `T$34` */, token: CancellationToken = definedExternally): dynamic /* Thenable | Thenable */

external fun <T : QuickPickItem> showQuickPick(items: Array<T>, options: QuickPickOptions /* QuickPickOptions & `T$34` */): dynamic /* Thenable | Thenable */

external fun <T : QuickPickItem> showQuickPick(items: Thenable<Array<T>>, options: QuickPickOptions /* QuickPickOptions & `T$34` */, token: CancellationToken = definedExternally): dynamic /* Thenable | Thenable */

external fun <T : QuickPickItem> showQuickPick(items: Thenable<Array<T>>, options: QuickPickOptions /* QuickPickOptions & `T$34` */): dynamic /* Thenable | Thenable */

external fun <T : QuickPickItem> showQuickPick(items: Array<T>): Thenable<T?>

external fun <T : QuickPickItem> showQuickPick(items: Thenable<Array<T>>): Thenable<T?>

external fun showWorkspaceFolderPick(options: WorkspaceFolderPickOptions = definedExternally): Thenable<WorkspaceFolder?>

external fun showOpenDialog(options: OpenDialogOptions = definedExternally): Thenable<Array<Uri>?>

external fun showSaveDialog(options: SaveDialogOptions = definedExternally): Thenable<Uri?>

external fun showInputBox(options: InputBoxOptions = definedExternally, token: CancellationToken = definedExternally): Thenable<String?>

external fun <T : QuickPickItem> createQuickPick(): QuickPick<T>

external fun createInputBox(): InputBox

external fun createOutputChannel(name: String): OutputChannel

external interface `T$35` {
    var viewColumn: ViewColumn
    var preserveFocus: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external fun createWebviewPanel(viewType: String, title: String, showOptions: ViewColumn, options: WebviewPanelOptions /* WebviewPanelOptions & WebviewOptions */ = definedExternally): WebviewPanel

external fun createWebviewPanel(viewType: String, title: String, showOptions: ViewColumn): WebviewPanel

external fun createWebviewPanel(viewType: String, title: String, showOptions: `T$35`, options: WebviewPanelOptions /* WebviewPanelOptions & WebviewOptions */ = definedExternally): WebviewPanel

external fun createWebviewPanel(viewType: String, title: String, showOptions: `T$35`): WebviewPanel

external fun setStatusBarMessage(text: String, hideAfterTimeout: Number): Disposable

external fun setStatusBarMessage(text: String, hideWhenDone: Thenable<Any>): Disposable

external fun setStatusBarMessage(text: String): Disposable

external fun <R> withScmProgress(task: (progress: Progress<Number>) -> Thenable<R>): Thenable<R>

external interface `T$36` {
    var message: String?
        get() = definedExternally
        set(value) = definedExternally
    var increment: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external fun <R> withProgress(options: ProgressOptions, task: (progress: Progress<`T$36`>, token: CancellationToken) -> Thenable<R>): Thenable<R>

external fun createStatusBarItem(alignment: StatusBarAlignment = definedExternally, priority: Number = definedExternally): StatusBarItem

external fun createStatusBarItem(): StatusBarItem

external fun createStatusBarItem(alignment: StatusBarAlignment = definedExternally): StatusBarItem

external fun createStatusBarItem(id: String, alignment: StatusBarAlignment = definedExternally, priority: Number = definedExternally): StatusBarItem

external fun createStatusBarItem(id: String): StatusBarItem

external fun createStatusBarItem(id: String, alignment: StatusBarAlignment = definedExternally): StatusBarItem

external fun createTerminal(name: String = definedExternally, shellPath: String = definedExternally, shellArgs: Array<String> = definedExternally): Terminal

external fun createTerminal(): Terminal

external fun createTerminal(name: String = definedExternally): Terminal

external fun createTerminal(name: String = definedExternally, shellPath: String = definedExternally): Terminal

external fun createTerminal(name: String = definedExternally, shellPath: String = definedExternally, shellArgs: String = definedExternally): Terminal

external fun createTerminal(options: TerminalOptions): Terminal

external fun createTerminal(options: ExtensionTerminalOptions): Terminal

external fun <T> registerTreeDataProvider(viewId: String, treeDataProvider: TreeDataProvider<T>): Disposable

external fun <T> createTreeView(viewId: String, options: TreeViewOptions<T>): TreeView<T>

external fun registerUriHandler(handler: UriHandler): Disposable

external fun registerWebviewPanelSerializer(viewType: String, serializer: WebviewPanelSerializer__0): Disposable

external interface `T$37` {
    var retainContextWhenHidden: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$38` {
    var webviewOptions: `T$37`?
        get() = definedExternally
        set(value) = definedExternally
}

external fun registerWebviewViewProvider(viewId: String, provider: WebviewViewProvider, options: `T$38` = definedExternally): Disposable

external interface `T$39` {
    var webviewOptions: WebviewPanelOptions?
        get() = definedExternally
        set(value) = definedExternally
    var supportsMultipleEditorsPerDocument: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external fun registerCustomEditorProvider(viewType: String, provider: CustomTextEditorProvider, options: `T$39` = definedExternally): Disposable

external fun registerCustomEditorProvider(viewType: String, provider: CustomTextEditorProvider): Disposable

external fun registerCustomEditorProvider(viewType: String, provider: CustomReadonlyEditorProvider__0, options: `T$39` = definedExternally): Disposable

external fun registerCustomEditorProvider(viewType: String, provider: CustomReadonlyEditorProvider__0): Disposable

external fun registerCustomEditorProvider(viewType: String, provider: CustomEditorProvider__0, options: `T$39` = definedExternally): Disposable

external fun registerCustomEditorProvider(viewType: String, provider: CustomEditorProvider__0): Disposable

external fun registerTerminalLinkProvider(provider: TerminalLinkProvider__0): Disposable

external fun registerTerminalProfileProvider(id: String, provider: TerminalProfileProvider): Disposable

external fun registerFileDecorationProvider(provider: FileDecorationProvider): Disposable

external var activeColorTheme: ColorTheme

external var onDidChangeActiveColorTheme: Event<ColorTheme>