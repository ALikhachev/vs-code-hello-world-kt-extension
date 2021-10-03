@file:JsModule("vscode")
@file:JsNonModule
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package vscode

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
import Thenable
import tsstdlib.Readonly

external var version: String

external interface Command {
    var title: String
    var command: String
    var tooltip: String?
        get() = definedExternally
        set(value) = definedExternally
    var arguments: Array<Any>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface TextLine {
    var lineNumber: Number
    var text: String
    var range: Range
    var rangeIncludingLineBreak: Range
    var firstNonWhitespaceCharacterIndex: Number
    var isEmptyOrWhitespace: Boolean
}

external interface TextDocument {
    var uri: Uri
    var fileName: String
    var isUntitled: Boolean
    var languageId: String
    var version: Number
    var isDirty: Boolean
    var isClosed: Boolean
    fun save(): Thenable<Boolean>
    var eol: EndOfLine
    var lineCount: Number
    fun lineAt(line: Number): TextLine
    fun lineAt(position: Position): TextLine
    fun offsetAt(position: Position): Number
    fun positionAt(offset: Number): Position
    fun getText(range: Range = definedExternally): String
    fun getWordRangeAtPosition(position: Position, regex: RegExp = definedExternally): Range?
    fun validateRange(range: Range): Range
    fun validatePosition(position: Position): Position
}

external interface `T$0` {
    var lineDelta: Number?
        get() = definedExternally
        set(value) = definedExternally
    var characterDelta: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$1` {
    var line: Number?
        get() = definedExternally
        set(value) = definedExternally
    var character: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external open class Position(line: Number, character: Number) {
    open var line: Number
    open var character: Number
    open fun isBefore(other: Position): Boolean
    open fun isBeforeOrEqual(other: Position): Boolean
    open fun isAfter(other: Position): Boolean
    open fun isAfterOrEqual(other: Position): Boolean
    open fun isEqual(other: Position): Boolean
    open fun compareTo(other: Position): Number
    open fun translate(lineDelta: Number = definedExternally, characterDelta: Number = definedExternally): Position
    open fun translate(): Position
    open fun translate(lineDelta: Number = definedExternally): Position
    open fun translate(change: `T$0`): Position
    open fun with(line: Number = definedExternally, character: Number = definedExternally): Position
    open fun with(): Position
    open fun with(line: Number = definedExternally): Position
    open fun with(change: `T$1`): Position
}

external interface `T$2` {
    var start: Position?
        get() = definedExternally
        set(value) = definedExternally
    var end: Position?
        get() = definedExternally
        set(value) = definedExternally
}

external open class Range {
    open var start: Position
    open var end: Position
    constructor(start: Position, end: Position)
    constructor(startLine: Number, startCharacter: Number, endLine: Number, endCharacter: Number)
    open var isEmpty: Boolean
    open var isSingleLine: Boolean
    open fun contains(positionOrRange: Position): Boolean
    open fun contains(positionOrRange: Range): Boolean
    open fun isEqual(other: Range): Boolean
    open fun intersection(range: Range): Range?
    open fun union(other: Range): Range
    open fun with(start: Position = definedExternally, end: Position = definedExternally): Range
    open fun with(): Range
    open fun with(start: Position = definedExternally): Range
    open fun with(change: `T$2`): Range
}

external open class Selection : Range {
    constructor(anchor: Position, active: Position)
    constructor(anchorLine: Number, anchorCharacter: Number, activeLine: Number, activeCharacter: Number)
    open var anchor: Position
    open var active: Position
    open var isReversed: Boolean
}

external enum class TextEditorSelectionChangeKind {
    Keyboard /* = 1 */,
    Mouse /* = 2 */,
    Command /* = 3 */
}

external interface TextEditorSelectionChangeEvent {
    var textEditor: TextEditor
    var selections: Array<Selection>
    var kind: TextEditorSelectionChangeKind?
        get() = definedExternally
        set(value) = definedExternally
}

external interface TextEditorVisibleRangesChangeEvent {
    var textEditor: TextEditor
    var visibleRanges: Array<Range>
}

external interface TextEditorOptionsChangeEvent {
    var textEditor: TextEditor
    var options: TextEditorOptions
}

external interface TextEditorViewColumnChangeEvent {
    var textEditor: TextEditor
    var viewColumn: ViewColumn
}

external enum class TextEditorCursorStyle {
    Line /* = 1 */,
    Block /* = 2 */,
    Underline /* = 3 */,
    LineThin /* = 4 */,
    BlockOutline /* = 5 */,
    UnderlineThin /* = 6 */
}

external enum class TextEditorLineNumbersStyle {
    Off /* = 0 */,
    On /* = 1 */,
    Relative /* = 2 */
}

external interface TextEditorOptions {
    var tabSize: dynamic /* Number? | String? */
        get() = definedExternally
        set(value) = definedExternally
    var insertSpaces: dynamic /* Boolean? | String? */
        get() = definedExternally
        set(value) = definedExternally
    var cursorStyle: TextEditorCursorStyle?
        get() = definedExternally
        set(value) = definedExternally
    var lineNumbers: TextEditorLineNumbersStyle?
        get() = definedExternally
        set(value) = definedExternally
}

external interface TextEditorDecorationType {
    var key: String
    fun dispose()
}

external enum class TextEditorRevealType {
    Default /* = 0 */,
    InCenter /* = 1 */,
    InCenterIfOutsideViewport /* = 2 */,
    AtTop /* = 3 */
}

external enum class OverviewRulerLane {
    Left /* = 1 */,
    Center /* = 2 */,
    Right /* = 4 */,
    Full /* = 7 */
}

external enum class DecorationRangeBehavior {
    OpenOpen /* = 0 */,
    ClosedClosed /* = 1 */,
    OpenClosed /* = 2 */,
    ClosedOpen /* = 3 */
}

external interface TextDocumentShowOptions {
    var viewColumn: ViewColumn?
        get() = definedExternally
        set(value) = definedExternally
    var preserveFocus: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var preview: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var selection: Range?
        get() = definedExternally
        set(value) = definedExternally
}

external open class ThemeColor(id: String)

external open class ThemeIcon(id: String, color: ThemeColor = definedExternally) {
    open var id: String
    open var color: ThemeColor

    companion object {
        var File: ThemeIcon
        var Folder: ThemeIcon
    }
}

external interface ThemableDecorationRenderOptions {
    var backgroundColor: dynamic /* String? | ThemeColor? */
        get() = definedExternally
        set(value) = definedExternally
    var outline: String?
        get() = definedExternally
        set(value) = definedExternally
    var outlineColor: dynamic /* String? | ThemeColor? */
        get() = definedExternally
        set(value) = definedExternally
    var outlineStyle: String?
        get() = definedExternally
        set(value) = definedExternally
    var outlineWidth: String?
        get() = definedExternally
        set(value) = definedExternally
    var border: String?
        get() = definedExternally
        set(value) = definedExternally
    var borderColor: dynamic /* String? | ThemeColor? */
        get() = definedExternally
        set(value) = definedExternally
    var borderRadius: String?
        get() = definedExternally
        set(value) = definedExternally
    var borderSpacing: String?
        get() = definedExternally
        set(value) = definedExternally
    var borderStyle: String?
        get() = definedExternally
        set(value) = definedExternally
    var borderWidth: String?
        get() = definedExternally
        set(value) = definedExternally
    var fontStyle: String?
        get() = definedExternally
        set(value) = definedExternally
    var fontWeight: String?
        get() = definedExternally
        set(value) = definedExternally
    var textDecoration: String?
        get() = definedExternally
        set(value) = definedExternally
    var cursor: String?
        get() = definedExternally
        set(value) = definedExternally
    var color: dynamic /* String? | ThemeColor? */
        get() = definedExternally
        set(value) = definedExternally
    var opacity: String?
        get() = definedExternally
        set(value) = definedExternally
    var letterSpacing: String?
        get() = definedExternally
        set(value) = definedExternally
    var gutterIconPath: dynamic /* String? | Uri? */
        get() = definedExternally
        set(value) = definedExternally
    var gutterIconSize: String?
        get() = definedExternally
        set(value) = definedExternally
    var overviewRulerColor: dynamic /* String? | ThemeColor? */
        get() = definedExternally
        set(value) = definedExternally
    var before: ThemableDecorationAttachmentRenderOptions?
        get() = definedExternally
        set(value) = definedExternally
    var after: ThemableDecorationAttachmentRenderOptions?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ThemableDecorationAttachmentRenderOptions {
    var contentText: String?
        get() = definedExternally
        set(value) = definedExternally
    var contentIconPath: dynamic /* String? | Uri? */
        get() = definedExternally
        set(value) = definedExternally
    var border: String?
        get() = definedExternally
        set(value) = definedExternally
    var borderColor: dynamic /* String? | ThemeColor? */
        get() = definedExternally
        set(value) = definedExternally
    var fontStyle: String?
        get() = definedExternally
        set(value) = definedExternally
    var fontWeight: String?
        get() = definedExternally
        set(value) = definedExternally
    var textDecoration: String?
        get() = definedExternally
        set(value) = definedExternally
    var color: dynamic /* String? | ThemeColor? */
        get() = definedExternally
        set(value) = definedExternally
    var backgroundColor: dynamic /* String? | ThemeColor? */
        get() = definedExternally
        set(value) = definedExternally
    var margin: String?
        get() = definedExternally
        set(value) = definedExternally
    var width: String?
        get() = definedExternally
        set(value) = definedExternally
    var height: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface DecorationRenderOptions : ThemableDecorationRenderOptions {
    var isWholeLine: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var rangeBehavior: DecorationRangeBehavior?
        get() = definedExternally
        set(value) = definedExternally
    var overviewRulerLane: OverviewRulerLane?
        get() = definedExternally
        set(value) = definedExternally
    var light: ThemableDecorationRenderOptions?
        get() = definedExternally
        set(value) = definedExternally
    var dark: ThemableDecorationRenderOptions?
        get() = definedExternally
        set(value) = definedExternally
}

external interface DecorationOptions {
    var range: Range
    var hoverMessage: dynamic /* MarkdownString? | String? | `T$11`? | Array<dynamic /* MarkdownString | String | `T$11` */>? */
        get() = definedExternally
        set(value) = definedExternally
    var renderOptions: DecorationInstanceRenderOptions?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ThemableDecorationInstanceRenderOptions {
    var before: ThemableDecorationAttachmentRenderOptions?
        get() = definedExternally
        set(value) = definedExternally
    var after: ThemableDecorationAttachmentRenderOptions?
        get() = definedExternally
        set(value) = definedExternally
}

external interface DecorationInstanceRenderOptions : ThemableDecorationInstanceRenderOptions {
    var light: ThemableDecorationInstanceRenderOptions?
        get() = definedExternally
        set(value) = definedExternally
    var dark: ThemableDecorationInstanceRenderOptions?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$3` {
    var undoStopBefore: Boolean
    var undoStopAfter: Boolean
}

external interface TextEditor {
    var document: TextDocument
    var selection: Selection
    var selections: Array<Selection>
    var visibleRanges: Array<Range>
    var options: TextEditorOptions
    var viewColumn: ViewColumn?
        get() = definedExternally
        set(value) = definedExternally
    fun edit(callback: (editBuilder: TextEditorEdit) -> Unit, options: `T$3` = definedExternally): Thenable<Boolean>
    fun insertSnippet(snippet: SnippetString, location: Position = definedExternally, options: `T$3` = definedExternally): Thenable<Boolean>
    fun insertSnippet(snippet: SnippetString): Thenable<Boolean>
    fun insertSnippet(snippet: SnippetString, location: Position = definedExternally): Thenable<Boolean>
    fun insertSnippet(snippet: SnippetString, location: Range = definedExternally, options: `T$3` = definedExternally): Thenable<Boolean>
    fun insertSnippet(snippet: SnippetString, location: Range = definedExternally): Thenable<Boolean>
    fun insertSnippet(snippet: SnippetString, location: Array<Position> = definedExternally, options: `T$3` = definedExternally): Thenable<Boolean>
    fun insertSnippet(snippet: SnippetString, location: Array<Position> = definedExternally): Thenable<Boolean>
    fun insertSnippet(snippet: SnippetString, location: Array<Range> = definedExternally, options: `T$3` = definedExternally): Thenable<Boolean>
    fun insertSnippet(snippet: SnippetString, location: Array<Range> = definedExternally): Thenable<Boolean>
    fun setDecorations(decorationType: TextEditorDecorationType, rangesOrOptions: Array<Range>)
    fun setDecorations(decorationType: TextEditorDecorationType, rangesOrOptions: Array<DecorationOptions>)
    fun revealRange(range: Range, revealType: TextEditorRevealType = definedExternally)
    fun show(column: ViewColumn = definedExternally)
    fun hide()
}

external enum class EndOfLine {
    LF /* = 1 */,
    CRLF /* = 2 */
}

external interface TextEditorEdit {
    fun replace(location: Position, value: String)
    fun replace(location: Range, value: String)
    fun replace(location: Selection, value: String)
    fun insert(location: Position, value: String)
    fun delete(location: Range)
    fun delete(location: Selection)
    fun setEndOfLine(endOfLine: EndOfLine)
}

external interface `T$4` {
    var scheme: String
    var authority: String?
        get() = definedExternally
        set(value) = definedExternally
    var path: String?
        get() = definedExternally
        set(value) = definedExternally
    var query: String?
        get() = definedExternally
        set(value) = definedExternally
    var fragment: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$5` {
    var scheme: String?
        get() = definedExternally
        set(value) = definedExternally
    var authority: String?
        get() = definedExternally
        set(value) = definedExternally
    var path: String?
        get() = definedExternally
        set(value) = definedExternally
    var query: String?
        get() = definedExternally
        set(value) = definedExternally
    var fragment: String?
        get() = definedExternally
        set(value) = definedExternally
}

external open class Uri(scheme: String, authority: String, path: String, query: String, fragment: String) {
    open var scheme: String
    open var authority: String
    open var path: String
    open var query: String
    open var fragment: String
    open var fsPath: String
    open fun with(change: `T$5`): Uri
    open fun toString(skipEncoding: Boolean = definedExternally): String
    open fun toJSON(): Any

    companion object {
        fun parse(value: String, strict: Boolean = definedExternally): Uri
        fun file(path: String): Uri
        fun joinPath(base: Uri, vararg pathSegments: String): Uri
        fun from(components: `T$4`): Uri
    }
}

external interface CancellationToken {
    var isCancellationRequested: Boolean
    var onCancellationRequested: Event<Any>
}

external open class CancellationTokenSource {
    open var token: CancellationToken
    open fun cancel()
    open fun dispose()
}

external interface `T$6` {
    var dispose: () -> Any
}

external open class Disposable(callOnDispose: Function<*>) {
    open fun dispose(): Any

    companion object {
        fun from(vararg disposableLikes: `T$6`): Disposable
    }
}

external interface Event<T> {
    @nativeInvoke
    operator fun invoke(listener: (e: T) -> Any, thisArgs: Any = definedExternally, disposables: Array<Disposable> = definedExternally): Disposable
}

external open class EventEmitter<T> {
    open var event: Event<T>
    open fun fire(data: T)
    open fun dispose()
}

external interface FileSystemWatcher : Disposable {
    var ignoreCreateEvents: Boolean
    var ignoreChangeEvents: Boolean
    var ignoreDeleteEvents: Boolean
    var onDidCreate: Event<Uri>
    var onDidChange: Event<Uri>
    var onDidDelete: Event<Uri>
}

external interface TextDocumentContentProvider {
    var onDidChange: Event<Uri>?
        get() = definedExternally
        set(value) = definedExternally
    fun provideTextDocumentContent(uri: Uri, token: CancellationToken): dynamic /* String? | Thenable<String?>? */
}

external interface QuickPickItem {
    var label: String
    var description: String?
        get() = definedExternally
        set(value) = definedExternally
    var detail: String?
        get() = definedExternally
        set(value) = definedExternally
    var picked: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var alwaysShow: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `L$0` {
    @nativeInvoke
    operator fun invoke(item: QuickPickItem): Any
    @nativeInvoke
    operator fun invoke(item: String): Any
}

external interface QuickPickOptions {
    var title: String?
        get() = definedExternally
        set(value) = definedExternally
    var matchOnDescription: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var matchOnDetail: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var placeHolder: String?
        get() = definedExternally
        set(value) = definedExternally
    var ignoreFocusOut: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var canPickMany: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    val onDidSelectItem: `L$0`?
        get() = definedExternally
}

external interface WorkspaceFolderPickOptions {
    var placeHolder: String?
        get() = definedExternally
        set(value) = definedExternally
    var ignoreFocusOut: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$7` {
    @nativeGetter
    operator fun get(name: String): Array<String>?
    @nativeSetter
    operator fun set(name: String, value: Array<String>)
}

external interface OpenDialogOptions {
    var defaultUri: Uri?
        get() = definedExternally
        set(value) = definedExternally
    var openLabel: String?
        get() = definedExternally
        set(value) = definedExternally
    var canSelectFiles: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var canSelectFolders: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var canSelectMany: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var filters: `T$7`?
        get() = definedExternally
        set(value) = definedExternally
    var title: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$8` {
    @nativeGetter
    operator fun get(name: String): Array<String>?
    @nativeSetter
    operator fun set(name: String, value: Array<String>)
}

external interface SaveDialogOptions {
    var defaultUri: Uri?
        get() = definedExternally
        set(value) = definedExternally
    var saveLabel: String?
        get() = definedExternally
        set(value) = definedExternally
    var filters: `T$8`?
        get() = definedExternally
        set(value) = definedExternally
    var title: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface MessageItem {
    var title: String
    var isCloseAffordance: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface MessageOptions {
    var modal: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var detail: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface InputBoxOptions {
    var title: String?
        get() = definedExternally
        set(value) = definedExternally
    var value: String?
        get() = definedExternally
        set(value) = definedExternally
    var valueSelection: dynamic /* JsTuple<Number, Number> */
        get() = definedExternally
        set(value) = definedExternally
    var prompt: String?
        get() = definedExternally
        set(value) = definedExternally
    var placeHolder: String?
        get() = definedExternally
        set(value) = definedExternally
    var password: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var ignoreFocusOut: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    val validateInput: ((value: String) -> dynamic)?
}

external open class RelativePattern {
    open var base: String
    open var pattern: String
    constructor(base: WorkspaceFolder, pattern: String)
    constructor(base: Uri, pattern: String)
    constructor(base: String, pattern: String)
}

external interface DocumentFilter {
    var language: String?
        get() = definedExternally
        set(value) = definedExternally
    var scheme: String?
        get() = definedExternally
        set(value) = definedExternally
    var pattern: dynamic /* String? | RelativePattern? */
        get() = definedExternally
        set(value) = definedExternally
}

external open class CodeActionKind(value: String) {
    open var value: String
    open fun append(parts: String): CodeActionKind
    open fun intersects(other: CodeActionKind): Boolean
    open fun contains(other: CodeActionKind): Boolean

    companion object {
        var Empty: CodeActionKind
        var QuickFix: CodeActionKind
        var Refactor: CodeActionKind
        var RefactorExtract: CodeActionKind
        var RefactorInline: CodeActionKind
        var RefactorRewrite: CodeActionKind
        var Source: CodeActionKind
        var SourceOrganizeImports: CodeActionKind
        var SourceFixAll: CodeActionKind
    }
}

external enum class CodeActionTriggerKind {
    Invoke /* = 1 */,
    Automatic /* = 2 */
}

external interface CodeActionContext {
    var triggerKind: CodeActionTriggerKind
    var diagnostics: Array<Diagnostic>
    var only: CodeActionKind?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$9` {
    var reason: String
}

external open class CodeAction(title: String, kind: CodeActionKind = definedExternally) {
    open var title: String
    open var edit: WorkspaceEdit
    open var diagnostics: Array<Diagnostic>
    open var command: Command
    open var kind: CodeActionKind
    open var isPreferred: Boolean
    open var disabled: `T$9`
}

external interface CodeActionProvider<T : CodeAction> {
    fun provideCodeActions(document: TextDocument, range: Range, context: CodeActionContext, token: CancellationToken): dynamic /* Array<dynamic /* Command | T */>? | Thenable<Array<dynamic /* Command | T */>?>? */
    fun provideCodeActions(document: TextDocument, range: Selection, context: CodeActionContext, token: CancellationToken): dynamic /* Array<dynamic /* Command | T */>? | Thenable<Array<dynamic /* Command | T */>?>? */
    val resolveCodeAction: ((codeAction: T, token: CancellationToken) -> dynamic)?
}

external interface CodeActionProvider__0 : CodeActionProvider<CodeAction>

external interface `T$10` {
    var kind: CodeActionKind
    var command: Command
}

external interface CodeActionProviderMetadata {
    var providedCodeActionKinds: Array<CodeActionKind>?
        get() = definedExternally
        set(value) = definedExternally
    var documentation: Array<`T$10`>?
        get() = definedExternally
        set(value) = definedExternally
}

external open class CodeLens(range: Range, command: Command = definedExternally) {
    open var range: Range
    open var command: Command
    open var isResolved: Boolean
}

external interface CodeLensProvider<T : CodeLens> {
    var onDidChangeCodeLenses: Event<Unit>?
        get() = definedExternally
        set(value) = definedExternally
    fun provideCodeLenses(document: TextDocument, token: CancellationToken): dynamic /* Array<T>? | Thenable<Array<T>?>? */
    val resolveCodeLens: ((codeLens: T, token: CancellationToken) -> dynamic)?
}

external interface CodeLensProvider__0 : CodeLensProvider<CodeLens>

external interface DefinitionProvider {
    fun provideDefinition(document: TextDocument, position: Position, token: CancellationToken): dynamic /* Location? | Array<Location>? | Array<DefinitionLink>? | Thenable<dynamic /* Location? | Array<Location>? | Array<DefinitionLink>? */>? */
}

external interface ImplementationProvider {
    fun provideImplementation(document: TextDocument, position: Position, token: CancellationToken): dynamic /* Location? | Array<Location>? | Array<DefinitionLink>? | Thenable<dynamic /* Location? | Array<Location>? | Array<DefinitionLink>? */>? */
}

external interface TypeDefinitionProvider {
    fun provideTypeDefinition(document: TextDocument, position: Position, token: CancellationToken): dynamic /* Location? | Array<Location>? | Array<DefinitionLink>? | Thenable<dynamic /* Location? | Array<Location>? | Array<DefinitionLink>? */>? */
}

external interface DeclarationProvider {
    fun provideDeclaration(document: TextDocument, position: Position, token: CancellationToken): dynamic /* Location? | Array<Location>? | Array<LocationLink>? | Thenable<dynamic /* Location? | Array<Location>? | Array<LocationLink>? */>? */
}

external open class MarkdownString(value: String = definedExternally, supportThemeIcons: Boolean = definedExternally) {
    open var value: String
    open var isTrusted: Boolean
    open var supportThemeIcons: Boolean
    open fun appendText(value: String): MarkdownString
    open fun appendMarkdown(value: String): MarkdownString
    open fun appendCodeblock(value: String, language: String = definedExternally): MarkdownString
}

external interface `T$11` {
    var language: String
    var value: String
}

external open class Hover {
    open var contents: Array<dynamic /* MarkdownString | String | `T$11` */>
    open var range: Range
    constructor(contents: MarkdownString, range: Range = definedExternally)
    constructor(contents: MarkdownString)
    constructor(contents: String, range: Range = definedExternally)
    constructor(contents: String)
    constructor(contents: `T$11`, range: Range = definedExternally)
    constructor(contents: `T$11`)
    constructor(contents: Array<Any /* MarkdownString | String | `T$11` */>, range: Range = definedExternally)
    constructor(contents: Array<Any /* MarkdownString | String | `T$11` */>)
}

external interface HoverProvider {
    fun provideHover(document: TextDocument, position: Position, token: CancellationToken): dynamic /* Hover? | Thenable<Hover?>? */
}

external open class EvaluatableExpression(range: Range, expression: String = definedExternally) {
    open var range: Range
    open var expression: String
}

external interface EvaluatableExpressionProvider {
    fun provideEvaluatableExpression(document: TextDocument, position: Position, token: CancellationToken): dynamic /* EvaluatableExpression? | Thenable<EvaluatableExpression?>? */
}

external open class InlineValueText(range: Range, text: String) {
    open var range: Range
    open var text: String
}

external open class InlineValueVariableLookup(range: Range, variableName: String = definedExternally, caseSensitiveLookup: Boolean = definedExternally) {
    open var range: Range
    open var variableName: String
    open var caseSensitiveLookup: Boolean
}

external open class InlineValueEvaluatableExpression(range: Range, expression: String = definedExternally) {
    open var range: Range
    open var expression: String
}

external interface InlineValueContext {
    var frameId: Number
    var stoppedLocation: Range
}

external interface InlineValuesProvider {
    var onDidChangeInlineValues: Event<Unit>?
        get() = definedExternally
        set(value) = definedExternally
    fun provideInlineValues(document: TextDocument, viewPort: Range, context: InlineValueContext, token: CancellationToken): dynamic /* Array<dynamic /* InlineValueText | InlineValueVariableLookup | InlineValueEvaluatableExpression */>? | Thenable<Array<dynamic /* InlineValueText | InlineValueVariableLookup | InlineValueEvaluatableExpression */>?>? */
}

external enum class DocumentHighlightKind {
    Text /* = 0 */,
    Read /* = 1 */,
    Write /* = 2 */
}

external open class DocumentHighlight(range: Range, kind: DocumentHighlightKind = definedExternally) {
    open var range: Range
    open var kind: DocumentHighlightKind
}

external interface DocumentHighlightProvider {
    fun provideDocumentHighlights(document: TextDocument, position: Position, token: CancellationToken): dynamic /* Array<DocumentHighlight>? | Thenable<Array<DocumentHighlight>?>? */
}

external enum class SymbolKind {
    File /* = 0 */,
    Module /* = 1 */,
    Namespace /* = 2 */,
    Package /* = 3 */,
    Class /* = 4 */,
    Method /* = 5 */,
    Property /* = 6 */,
    Field /* = 7 */,
    Constructor /* = 8 */,
    Enum /* = 9 */,
    Interface /* = 10 */,
    Function /* = 11 */,
    Variable /* = 12 */,
    Constant /* = 13 */,
    String /* = 14 */,
    Number /* = 15 */,
    Boolean /* = 16 */,
    Array /* = 17 */,
    Object /* = 18 */,
    Key /* = 19 */,
    Null /* = 20 */,
    EnumMember /* = 21 */,
    Struct /* = 22 */,
    Event /* = 23 */,
    Operator /* = 24 */,
    TypeParameter /* = 25 */
}

external enum class SymbolTag {
    Deprecated /* = 1 */
}

external open class SymbolInformation {
    open var name: String
    open var containerName: String
    open var kind: SymbolKind
    open var tags: Array<SymbolTag>
    open var location: Location
    constructor(name: String, kind: SymbolKind, containerName: String, location: Location)
    constructor(name: String, kind: SymbolKind, range: Range, uri: Uri = definedExternally, containerName: String = definedExternally)
    constructor(name: String, kind: SymbolKind, range: Range)
    constructor(name: String, kind: SymbolKind, range: Range, uri: Uri = definedExternally)
}

external open class DocumentSymbol(name: String, detail: String, kind: SymbolKind, range: Range, selectionRange: Range) {
    open var name: String
    open var detail: String
    open var kind: SymbolKind
    open var tags: Array<SymbolTag>
    open var range: Range
    open var selectionRange: Range
    open var children: Array<DocumentSymbol>
}

external interface DocumentSymbolProvider {
    fun provideDocumentSymbols(document: TextDocument, token: CancellationToken): dynamic /* Array<SymbolInformation>? | Array<DocumentSymbol>? | Thenable<dynamic /* Array<SymbolInformation>? | Array<DocumentSymbol>? */>? */
}

external interface DocumentSymbolProviderMetadata {
    var label: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface WorkspaceSymbolProvider<T : SymbolInformation> {
    fun provideWorkspaceSymbols(query: String, token: CancellationToken): dynamic /* Array<T>? | Thenable<Array<T>?>? */
    val resolveWorkspaceSymbol: ((symbol: T, token: CancellationToken) -> dynamic)?
}

external interface WorkspaceSymbolProvider__0 : WorkspaceSymbolProvider<SymbolInformation>

external interface ReferenceContext {
    var includeDeclaration: Boolean
}

external interface ReferenceProvider {
    fun provideReferences(document: TextDocument, position: Position, context: ReferenceContext, token: CancellationToken): dynamic /* Array<Location>? | Thenable<Array<Location>?>? */
}

external open class TextEdit(range: Range, newText: String) {
    open var range: Range
    open var newText: String
    open var newEol: EndOfLine

    companion object {
        fun replace(range: Range, newText: String): TextEdit
        fun insert(position: Position, newText: String): TextEdit
        fun delete(range: Range): TextEdit
        fun setEndOfLine(eol: EndOfLine): TextEdit
    }
}

external interface `T$12` {
    var light: Uri
    var dark: Uri
}

external interface WorkspaceEditEntryMetadata {
    var needsConfirmation: Boolean
    var label: String
    var description: String?
        get() = definedExternally
        set(value) = definedExternally
    var iconPath: dynamic /* Uri? | `T$12`? | ThemeIcon? */
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$13` {
    var overwrite: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var ignoreIfExists: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$14` {
    var recursive: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var ignoreIfNotExists: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external open class WorkspaceEdit {
    open var size: Number
    open fun replace(uri: Uri, range: Range, newText: String, metadata: WorkspaceEditEntryMetadata = definedExternally)
    open fun insert(uri: Uri, position: Position, newText: String, metadata: WorkspaceEditEntryMetadata = definedExternally)
    open fun delete(uri: Uri, range: Range, metadata: WorkspaceEditEntryMetadata = definedExternally)
    open fun has(uri: Uri): Boolean
    open fun set(uri: Uri, edits: Array<TextEdit>)
    open fun get(uri: Uri): Array<TextEdit>
    open fun createFile(uri: Uri, options: `T$13` = definedExternally, metadata: WorkspaceEditEntryMetadata = definedExternally)
    open fun deleteFile(uri: Uri, options: `T$14` = definedExternally, metadata: WorkspaceEditEntryMetadata = definedExternally)
    open fun renameFile(oldUri: Uri, newUri: Uri, options: `T$13` = definedExternally, metadata: WorkspaceEditEntryMetadata = definedExternally)
    open fun entries(): Array<dynamic /* JsTuple<Uri, Array<TextEdit>> */>
}

external open class SnippetString(value: String = definedExternally) {
    open var value: String
    open fun appendText(string: String): SnippetString
    open fun appendTabstop(number: Number = definedExternally): SnippetString
    open fun appendPlaceholder(value: String, number: Number = definedExternally): SnippetString
    open fun appendPlaceholder(value: String): SnippetString
    open fun appendPlaceholder(value: (snippet: SnippetString) -> Any, number: Number = definedExternally): SnippetString
    open fun appendPlaceholder(value: (snippet: SnippetString) -> Any): SnippetString
    open fun appendChoice(values: Array<String>, number: Number = definedExternally): SnippetString
    open fun appendVariable(name: String, defaultValue: String): SnippetString
    open fun appendVariable(name: String, defaultValue: (snippet: SnippetString) -> Any): SnippetString
}

external interface `T$15` {
    var range: Range
    var placeholder: String
}

external interface RenameProvider {
    fun provideRenameEdits(document: TextDocument, position: Position, newName: String, token: CancellationToken): dynamic /* WorkspaceEdit? | Thenable<WorkspaceEdit?>? */
    val prepareRename: ((document: TextDocument, position: Position, token: CancellationToken) -> dynamic)?
}

external open class SemanticTokensLegend(tokenTypes: Array<String>, tokenModifiers: Array<String> = definedExternally) {
    open var tokenTypes: Array<String>
    open var tokenModifiers: Array<String>
}

external open class SemanticTokensBuilder(legend: SemanticTokensLegend = definedExternally) {
    open fun push(line: Number, char: Number, length: Number, tokenType: Number, tokenModifiers: Number = definedExternally)
    open fun push(line: Number, char: Number, length: Number, tokenType: Number)
    open fun push(range: Range, tokenType: String, tokenModifiers: Array<String> = definedExternally)
    open fun push(range: Range, tokenType: String)
    open fun build(resultId: String = definedExternally): SemanticTokens
}

external open class SemanticTokens(data: Uint32Array, resultId: String = definedExternally) {
    open var resultId: String
    open var data: Uint32Array
}

external open class SemanticTokensEdits(edits: Array<SemanticTokensEdit>, resultId: String = definedExternally) {
    open var resultId: String
    open var edits: Array<SemanticTokensEdit>
}

external open class SemanticTokensEdit(start: Number, deleteCount: Number, data: Uint32Array = definedExternally) {
    open var start: Number
    open var deleteCount: Number
    open var data: Uint32Array
}

external interface DocumentSemanticTokensProvider {
    var onDidChangeSemanticTokens: Event<Unit>?
        get() = definedExternally
        set(value) = definedExternally
    fun provideDocumentSemanticTokens(document: TextDocument, token: CancellationToken): dynamic /* SemanticTokens? | Thenable<SemanticTokens?>? */
    val provideDocumentSemanticTokensEdits: ((document: TextDocument, previousResultId: String, token: CancellationToken) -> dynamic)?
}

external interface DocumentRangeSemanticTokensProvider {
    fun provideDocumentRangeSemanticTokens(document: TextDocument, range: Range, token: CancellationToken): dynamic /* SemanticTokens? | Thenable<SemanticTokens?>? */
}

external interface FormattingOptions {
    var tabSize: Number
    var insertSpaces: Boolean
    @nativeGetter
    operator fun get(key: String): dynamic /* Boolean? | Number? | String? */
    @nativeSetter
    operator fun set(key: String, value: Boolean)
    @nativeSetter
    operator fun set(key: String, value: Number)
    @nativeSetter
    operator fun set(key: String, value: String)
}

external interface DocumentFormattingEditProvider {
    fun provideDocumentFormattingEdits(document: TextDocument, options: FormattingOptions, token: CancellationToken): dynamic /* Array<TextEdit>? | Thenable<Array<TextEdit>?>? */
}

external interface DocumentRangeFormattingEditProvider {
    fun provideDocumentRangeFormattingEdits(document: TextDocument, range: Range, options: FormattingOptions, token: CancellationToken): dynamic /* Array<TextEdit>? | Thenable<Array<TextEdit>?>? */
}

external interface OnTypeFormattingEditProvider {
    fun provideOnTypeFormattingEdits(document: TextDocument, position: Position, ch: String, options: FormattingOptions, token: CancellationToken): dynamic /* Array<TextEdit>? | Thenable<Array<TextEdit>?>? */
}

external open class ParameterInformation {
    open var label: dynamic /* String | JsTuple<Number, Number> */
    open var documentation: dynamic /* String | MarkdownString */
    constructor(label: String, documentation: String = definedExternally)
    constructor(label: String)
    constructor(label: String, documentation: MarkdownString = definedExternally)
    constructor(label: Any, documentation: String = definedExternally)
    constructor(label: Any)
    constructor(label: Any, documentation: MarkdownString = definedExternally)
}

external open class SignatureInformation {
    open var label: String
    open var documentation: dynamic /* String | MarkdownString */
    open var parameters: Array<ParameterInformation>
    open var activeParameter: Number
    constructor(label: String, documentation: String = definedExternally)
    constructor(label: String)
    constructor(label: String, documentation: MarkdownString = definedExternally)
}

external open class SignatureHelp {
    open var signatures: Array<SignatureInformation>
    open var activeSignature: Number
    open var activeParameter: Number
}

external enum class SignatureHelpTriggerKind {
    Invoke /* = 1 */,
    TriggerCharacter /* = 2 */,
    ContentChange /* = 3 */
}

external interface SignatureHelpContext {
    var triggerKind: SignatureHelpTriggerKind
    var triggerCharacter: String?
        get() = definedExternally
        set(value) = definedExternally
    var isRetrigger: Boolean
    var activeSignatureHelp: SignatureHelp?
        get() = definedExternally
        set(value) = definedExternally
}

external interface SignatureHelpProvider {
    fun provideSignatureHelp(document: TextDocument, position: Position, token: CancellationToken, context: SignatureHelpContext): dynamic /* SignatureHelp? | Thenable<SignatureHelp?>? */
}

external interface SignatureHelpProviderMetadata {
    var triggerCharacters: Array<String>
    var retriggerCharacters: Array<String>
}

external interface CompletionItemLabel {
    var label: String
    var detail: String?
        get() = definedExternally
        set(value) = definedExternally
    var description: String?
        get() = definedExternally
        set(value) = definedExternally
}

external enum class CompletionItemKind {
    Text /* = 0 */,
    Method /* = 1 */,
    Function /* = 2 */,
    Constructor /* = 3 */,
    Field /* = 4 */,
    Variable /* = 5 */,
    Class /* = 6 */,
    Interface /* = 7 */,
    Module /* = 8 */,
    Property /* = 9 */,
    Unit /* = 10 */,
    Value /* = 11 */,
    Enum /* = 12 */,
    Keyword /* = 13 */,
    Snippet /* = 14 */,
    Color /* = 15 */,
    Reference /* = 17 */,
    File /* = 16 */,
    Folder /* = 18 */,
    EnumMember /* = 19 */,
    Constant /* = 20 */,
    Struct /* = 21 */,
    Event /* = 22 */,
    Operator /* = 23 */,
    TypeParameter /* = 24 */,
    User /* = 25 */,
    Issue /* = 26 */
}

external enum class CompletionItemTag {
    Deprecated /* = 1 */
}

external interface `T$16` {
    var inserting: Range
    var replacing: Range
}

external open class CompletionItem {
    open var label: dynamic /* String | CompletionItemLabel */
    open var kind: CompletionItemKind
    open var tags: Array<CompletionItemTag>
    open var detail: String
    open var documentation: dynamic /* String | MarkdownString */
    open var sortText: String
    open var filterText: String
    open var preselect: Boolean
    open var insertText: dynamic /* String | SnippetString */
    open var range: dynamic /* Range | `T$16` */
    open var commitCharacters: Array<String>
    open var keepWhitespace: Boolean
    open var textEdit: TextEdit
    open var additionalTextEdits: Array<TextEdit>
    open var command: Command
    constructor(label: String, kind: CompletionItemKind = definedExternally)
    constructor(label: String)
    constructor(label: CompletionItemLabel, kind: CompletionItemKind = definedExternally)
    constructor(label: CompletionItemLabel)
}

external open class CompletionList<T : CompletionItem>(items: Array<T> = definedExternally, isIncomplete: Boolean = definedExternally) {
    open var isIncomplete: Boolean
    open var items: Array<T>
}

external enum class CompletionTriggerKind {
    Invoke /* = 0 */,
    TriggerCharacter /* = 1 */,
    TriggerForIncompleteCompletions /* = 2 */
}

external interface CompletionContext {
    var triggerKind: CompletionTriggerKind
    var triggerCharacter: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface CompletionItemProvider<T : CompletionItem> {
    fun provideCompletionItems(document: TextDocument, position: Position, token: CancellationToken, context: CompletionContext): dynamic /* Array<T>? | CompletionList<T>? | Thenable<dynamic /* Array<T>? | CompletionList<T>? */>? */
    val resolveCompletionItem: ((item: T, token: CancellationToken) -> dynamic)?
}

external interface CompletionItemProvider__0 : CompletionItemProvider<CompletionItem>

external open class DocumentLink(range: Range, target: Uri = definedExternally) {
    open var range: Range
    open var target: Uri
    open var tooltip: String
}

external interface DocumentLinkProvider<T : DocumentLink> {
    fun provideDocumentLinks(document: TextDocument, token: CancellationToken): dynamic /* Array<T>? | Thenable<Array<T>?>? */
    val resolveDocumentLink: ((link: T, token: CancellationToken) -> dynamic)?
}

external interface DocumentLinkProvider__0 : DocumentLinkProvider<DocumentLink>

external open class Color(red: Number, green: Number, blue: Number, alpha: Number) {
    open var red: Number
    open var green: Number
    open var blue: Number
    open var alpha: Number
}

external open class ColorInformation(range: Range, color: Color) {
    open var range: Range
    open var color: Color
}

external open class ColorPresentation(label: String) {
    open var label: String
    open var textEdit: TextEdit
    open var additionalTextEdits: Array<TextEdit>
}

external interface `T$17` {
    var document: TextDocument
    var range: Range
}

external interface DocumentColorProvider {
    fun provideDocumentColors(document: TextDocument, token: CancellationToken): dynamic /* Array<ColorInformation>? | Thenable<Array<ColorInformation>?>? */
    fun provideColorPresentations(color: Color, context: `T$17`, token: CancellationToken): dynamic /* Array<ColorPresentation>? | Thenable<Array<ColorPresentation>?>? */
}

external open class FoldingRange(start: Number, end: Number, kind: FoldingRangeKind = definedExternally) {
    open var start: Number
    open var end: Number
    open var kind: FoldingRangeKind
}

external enum class FoldingRangeKind {
    Comment /* = 1 */,
    Imports /* = 2 */,
    Region /* = 3 */
}

external interface FoldingContext

external interface FoldingRangeProvider {
    var onDidChangeFoldingRanges: Event<Unit>?
        get() = definedExternally
        set(value) = definedExternally
    fun provideFoldingRanges(document: TextDocument, context: FoldingContext, token: CancellationToken): dynamic /* Array<FoldingRange>? | Thenable<Array<FoldingRange>?>? */
}

external open class SelectionRange(range: Range, parent: SelectionRange = definedExternally) {
    open var range: Range
    open var parent: SelectionRange
}

external interface SelectionRangeProvider {
    fun provideSelectionRanges(document: TextDocument, positions: Array<Position>, token: CancellationToken): dynamic /* Array<SelectionRange>? | Thenable<Array<SelectionRange>?>? */
}

external open class CallHierarchyItem(kind: SymbolKind, name: String, detail: String, uri: Uri, range: Range, selectionRange: Range) {
    open var name: String
    open var kind: SymbolKind
    open var tags: Array<SymbolTag>
    open var detail: String
    open var uri: Uri
    open var range: Range
    open var selectionRange: Range
}

external open class CallHierarchyIncomingCall(item: CallHierarchyItem, fromRanges: Array<Range>) {
    open var from: CallHierarchyItem
    open var fromRanges: Array<Range>
}

external open class CallHierarchyOutgoingCall(item: CallHierarchyItem, fromRanges: Array<Range>) {
    open var to: CallHierarchyItem
    open var fromRanges: Array<Range>
}

external interface CallHierarchyProvider {
    fun prepareCallHierarchy(document: TextDocument, position: Position, token: CancellationToken): dynamic /* CallHierarchyItem? | Array<CallHierarchyItem>? | Thenable<dynamic /* CallHierarchyItem? | Array<CallHierarchyItem>? */>? */
    fun provideCallHierarchyIncomingCalls(item: CallHierarchyItem, token: CancellationToken): dynamic /* Array<CallHierarchyIncomingCall>? | Thenable<Array<CallHierarchyIncomingCall>?>? */
    fun provideCallHierarchyOutgoingCalls(item: CallHierarchyItem, token: CancellationToken): dynamic /* Array<CallHierarchyOutgoingCall>? | Thenable<Array<CallHierarchyOutgoingCall>?>? */
}

external open class LinkedEditingRanges(ranges: Array<Range>, wordPattern: RegExp = definedExternally) {
    open var ranges: Array<Range>
    open var wordPattern: RegExp
}

external interface LinkedEditingRangeProvider {
    fun provideLinkedEditingRanges(document: TextDocument, position: Position, token: CancellationToken): dynamic /* LinkedEditingRanges? | Thenable<LinkedEditingRanges?>? */
}

external interface CommentRule {
    var lineComment: String?
        get() = definedExternally
        set(value) = definedExternally
    var blockComment: dynamic /* JsTuple<String, String> */
        get() = definedExternally
        set(value) = definedExternally
}

external interface IndentationRule {
    var decreaseIndentPattern: RegExp
    var increaseIndentPattern: RegExp
    var indentNextLinePattern: RegExp?
        get() = definedExternally
        set(value) = definedExternally
    var unIndentedLinePattern: RegExp?
        get() = definedExternally
        set(value) = definedExternally
}

external enum class IndentAction {
    None /* = 0 */,
    Indent /* = 1 */,
    IndentOutdent /* = 2 */,
    Outdent /* = 3 */
}

external interface EnterAction {
    var indentAction: IndentAction
    var appendText: String?
        get() = definedExternally
        set(value) = definedExternally
    var removeText: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface OnEnterRule {
    var beforeText: RegExp
    var afterText: RegExp?
        get() = definedExternally
        set(value) = definedExternally
    var previousLineText: RegExp?
        get() = definedExternally
        set(value) = definedExternally
    var action: EnterAction
}

external interface `T$18` {
    var scope: String
    var open: String
    var lineStart: String
    var close: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$19` {
    var brackets: Any?
        get() = definedExternally
        set(value) = definedExternally
    var docComment: `T$18`?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$20` {
    var open: String
    var close: String
    var notIn: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$21` {
    var autoClosingPairs: Array<`T$20`>
}

external interface LanguageConfiguration {
    var comments: CommentRule?
        get() = definedExternally
        set(value) = definedExternally
    var brackets: Array<dynamic /* JsTuple<String, String> */>?
        get() = definedExternally
        set(value) = definedExternally
    var wordPattern: RegExp?
        get() = definedExternally
        set(value) = definedExternally
    var indentationRules: IndentationRule?
        get() = definedExternally
        set(value) = definedExternally
    var onEnterRules: Array<OnEnterRule>?
        get() = definedExternally
        set(value) = definedExternally
    var __electricCharacterSupport: `T$19`?
        get() = definedExternally
        set(value) = definedExternally
    var __characterPairSupport: `T$21`?
        get() = definedExternally
        set(value) = definedExternally
}

external enum class ConfigurationTarget {
    Global /* = 1 */,
    Workspace /* = 2 */,
    WorkspaceFolder /* = 3 */
}

external interface `T$22`<T> {
    var key: String
    var defaultValue: T?
        get() = definedExternally
        set(value) = definedExternally
    var globalValue: T?
        get() = definedExternally
        set(value) = definedExternally
    var workspaceValue: T?
        get() = definedExternally
        set(value) = definedExternally
    var workspaceFolderValue: T?
        get() = definedExternally
        set(value) = definedExternally
    var defaultLanguageValue: T?
        get() = definedExternally
        set(value) = definedExternally
    var globalLanguageValue: T?
        get() = definedExternally
        set(value) = definedExternally
    var workspaceLanguageValue: T?
        get() = definedExternally
        set(value) = definedExternally
    var workspaceFolderLanguageValue: T?
        get() = definedExternally
        set(value) = definedExternally
    var languageIds: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface WorkspaceConfiguration {
    fun <T> get(section: String): T?
    fun <T> get(section: String, defaultValue: T): T
    fun has(section: String): Boolean
    fun <T> inspect(section: String): `T$22`<T>?
    fun update(section: String, value: Any, configurationTarget: ConfigurationTarget? = definedExternally, overrideInLanguage: Boolean = definedExternally): Thenable<Unit>
    fun update(section: String, value: Any): Thenable<Unit>
    fun update(section: String, value: Any, configurationTarget: ConfigurationTarget? = definedExternally): Thenable<Unit>
    fun update(section: String, value: Any, configurationTarget: Boolean? = definedExternally, overrideInLanguage: Boolean = definedExternally): Thenable<Unit>
    fun update(section: String, value: Any, configurationTarget: Boolean? = definedExternally): Thenable<Unit>
    @nativeGetter
    operator fun get(key: String): Any?
    @nativeSetter
    operator fun set(key: String, value: Any)
}

external open class Location {
    open var uri: Uri
    open var range: Range
    constructor(uri: Uri, rangeOrPosition: Range)
    constructor(uri: Uri, rangeOrPosition: Position)
}

external interface LocationLink {
    var originSelectionRange: Range?
        get() = definedExternally
        set(value) = definedExternally
    var targetUri: Uri
    var targetRange: Range
    var targetSelectionRange: Range?
        get() = definedExternally
        set(value) = definedExternally
}

external interface DiagnosticChangeEvent {
    var uris: Array<Uri>
}

external enum class DiagnosticSeverity {
    Error /* = 0 */,
    Warning /* = 1 */,
    Information /* = 2 */,
    Hint /* = 3 */
}

external open class DiagnosticRelatedInformation(location: Location, message: String) {
    open var location: Location
    open var message: String
}

external enum class DiagnosticTag {
    Unnecessary /* = 1 */,
    Deprecated /* = 2 */
}

external interface `T$23` {
    var value: dynamic /* String | Number */
        get() = definedExternally
        set(value) = definedExternally
    var target: Uri
}

external open class Diagnostic(range: Range, message: String, severity: DiagnosticSeverity = definedExternally) {
    open var range: Range
    open var message: String
    open var severity: DiagnosticSeverity
    open var source: String
    open var code: dynamic /* String | Number | `T$23` */
    open var relatedInformation: Array<DiagnosticRelatedInformation>
    open var tags: Array<DiagnosticTag>
}

external interface DiagnosticCollection {
    var name: String
    fun set(uri: Uri, diagnostics: Array<Diagnostic>?)
    fun set(entries: Array<Any /* JsTuple<Uri, Array<Diagnostic>?> */>)
    fun delete(uri: Uri)
    fun clear()
    fun forEach(callback: (uri: Uri, diagnostics: Array<Diagnostic>, collection: DiagnosticCollection) -> Any, thisArg: Any = definedExternally)
    fun get(uri: Uri): Array<Diagnostic>?
    fun has(uri: Uri): Boolean
    fun dispose()
}

external enum class ViewColumn {
    Active /* = -1 */,
    Beside /* = -2 */,
    One /* = 1 */,
    Two /* = 2 */,
    Three /* = 3 */,
    Four /* = 4 */,
    Five /* = 5 */,
    Six /* = 6 */,
    Seven /* = 7 */,
    Eight /* = 8 */,
    Nine /* = 9 */
}

external interface OutputChannel {
    var name: String
    fun append(value: String)
    fun appendLine(value: String)
    fun clear()
    fun show(preserveFocus: Boolean = definedExternally)
    fun show()
    fun show(column: ViewColumn = definedExternally, preserveFocus: Boolean = definedExternally)
    fun show(column: ViewColumn = definedExternally)
    fun hide()
    fun dispose()
}

external interface AccessibilityInformation {
    var label: String
    var role: String?
        get() = definedExternally
        set(value) = definedExternally
}

external enum class StatusBarAlignment {
    Left /* = 1 */,
    Right /* = 2 */
}

external interface StatusBarItem {
    var id: String
    var alignment: StatusBarAlignment
    var priority: Number?
        get() = definedExternally
        set(value) = definedExternally
    var name: String?
    var text: String
    var tooltip: dynamic /* String? | MarkdownString? */
        get() = definedExternally
        set(value) = definedExternally
    var color: dynamic /* String? | ThemeColor? */
        get() = definedExternally
        set(value) = definedExternally
    var backgroundColor: ThemeColor?
    var command: dynamic /* String? | Command? */
        get() = definedExternally
        set(value) = definedExternally
    var accessibilityInformation: AccessibilityInformation?
        get() = definedExternally
        set(value) = definedExternally
    fun show()
    fun hide()
    fun dispose()
}

external interface Progress<T> {
    fun report(value: T)
}

external interface Terminal {
    var name: String
    var processId: Thenable<Number?>
    var creationOptions: Readonly<dynamic /* TerminalOptions | ExtensionTerminalOptions */>
    var exitStatus: TerminalExitStatus?
    fun sendText(text: String, addNewLine: Boolean = definedExternally)
    fun show(preserveFocus: Boolean = definedExternally)
    fun hide()
    fun dispose()
}

external interface TerminalLinkContext {
    var line: String
    var terminal: Terminal
}

external interface TerminalLinkProvider<T : TerminalLink> {
    fun provideTerminalLinks(context: TerminalLinkContext, token: CancellationToken): dynamic /* Array<T>? | Thenable<Array<T>?>? */
    fun handleTerminalLink(link: T): dynamic /* Unit? | Thenable<Unit?>? */
}

external interface TerminalLinkProvider__0 : TerminalLinkProvider<TerminalLink>

external open class TerminalLink(startIndex: Number, length: Number, tooltip: String = definedExternally) {
    open var startIndex: Number
    open var length: Number
    open var tooltip: String
}

external interface TerminalProfileProvider {
    fun provideTerminalProfile(token: CancellationToken): dynamic /* TerminalProfile? | Thenable<TerminalProfile?>? */
}

external open class TerminalProfile {
    open var options: dynamic /* TerminalOptions | ExtensionTerminalOptions */
    constructor(options: TerminalOptions)
    constructor(options: ExtensionTerminalOptions)
}

external open class FileDecoration(badge: String = definedExternally, tooltip: String = definedExternally, color: ThemeColor = definedExternally) {
    open var badge: String
    open var tooltip: String
    open var color: ThemeColor
    open var propagate: Boolean
}

external interface FileDecorationProvider {
    var onDidChangeFileDecorations: Event<dynamic /* Uri? | Array<Uri>? */>?
        get() = definedExternally
        set(value) = definedExternally
    fun provideFileDecoration(uri: Uri, token: CancellationToken): dynamic /* FileDecoration? | Thenable<FileDecoration?>? */
}

external enum class ExtensionKind {
    UI /* = 1 */,
    Workspace /* = 2 */
}

external interface Extension<T> {
    var id: String
    var extensionUri: Uri
    var extensionPath: String
    var isActive: Boolean
    var packageJSON: Any
    var extensionKind: ExtensionKind
    var exports: T
    fun activate(): Thenable<T>
}

external enum class ExtensionMode {
    Production /* = 1 */,
    Development /* = 2 */,
    Test /* = 3 */
}

external interface `T$24` {
    fun dispose(): Any
}

external interface `T$25` {
    fun setKeysForSync(keys: Array<String>)
}

external interface ExtensionContext {
    var subscriptions: Array<`T$24`>
    var workspaceState: Memento
    var globalState: Memento /* Memento & `T$25` */
    var secrets: SecretStorage
    var extensionUri: Uri
    var extensionPath: String
    var environmentVariableCollection: EnvironmentVariableCollection
    fun asAbsolutePath(relativePath: String): String
    var storageUri: Uri?
    var storagePath: String?
    var globalStorageUri: Uri
    var globalStoragePath: String
    var logUri: Uri
    var logPath: String
    var extensionMode: ExtensionMode
    var extension: Extension<Any>
}

external interface Memento {
    fun keys(): Array<String>
    fun <T> get(key: String): T?
    fun <T> get(key: String, defaultValue: T): T
    fun update(key: String, value: Any): Thenable<Unit>
}

external interface SecretStorageChangeEvent {
    var key: String
}

external interface SecretStorage {
    fun get(key: String): Thenable<String?>
    fun store(key: String, value: String): Thenable<Unit>
    fun delete(key: String): Thenable<Unit>
    var onDidChange: Event<SecretStorageChangeEvent>
}

external enum class ColorThemeKind {
    Light /* = 1 */,
    Dark /* = 2 */,
    HighContrast /* = 3 */
}

external interface ColorTheme {
    var kind: ColorThemeKind
}

external enum class TaskRevealKind {
    Always /* = 1 */,
    Silent /* = 2 */,
    Never /* = 3 */
}

external enum class TaskPanelKind {
    Shared /* = 1 */,
    Dedicated /* = 2 */,
    New /* = 3 */
}

external interface TaskPresentationOptions {
    var reveal: TaskRevealKind?
        get() = definedExternally
        set(value) = definedExternally
    var echo: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var focus: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var panel: TaskPanelKind?
        get() = definedExternally
        set(value) = definedExternally
    var showReuseMessage: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var clear: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external open class TaskGroup(id: String, label: String) {
    open var isDefault: Boolean
    open var id: String

    companion object {
        var Clean: TaskGroup
        var Build: TaskGroup
        var Rebuild: TaskGroup
        var Test: TaskGroup
    }
}

external interface TaskDefinition {
    var type: String
    @nativeGetter
    operator fun get(name: String): Any?
    @nativeSetter
    operator fun set(name: String, value: Any)
}

external interface `T$26` {
    @nativeGetter
    operator fun get(key: String): String?
    @nativeSetter
    operator fun set(key: String, value: String)
}

external interface ProcessExecutionOptions {
    var cwd: String?
        get() = definedExternally
        set(value) = definedExternally
    var env: `T$26`?
        get() = definedExternally
        set(value) = definedExternally
}

external open class ProcessExecution {
    constructor(process: String, options: ProcessExecutionOptions = definedExternally)
    constructor(process: String)
    constructor(process: String, args: Array<String>, options: ProcessExecutionOptions = definedExternally)
    constructor(process: String, args: Array<String>)
    open var process: String
    open var args: Array<String>
    open var options: ProcessExecutionOptions
}

external interface `T$27` {
    var escapeChar: String
    var charsToEscape: String
}

external interface ShellQuotingOptions {
    var escape: dynamic /* String? | `T$27`? */
        get() = definedExternally
        set(value) = definedExternally
    var strong: String?
        get() = definedExternally
        set(value) = definedExternally
    var weak: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ShellExecutionOptions {
    var executable: String?
        get() = definedExternally
        set(value) = definedExternally
    var shellArgs: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
    var shellQuoting: ShellQuotingOptions?
        get() = definedExternally
        set(value) = definedExternally
    var cwd: String?
        get() = definedExternally
        set(value) = definedExternally
    var env: `T$26`?
        get() = definedExternally
        set(value) = definedExternally
}

external enum class ShellQuoting {
    Escape /* = 1 */,
    Strong /* = 2 */,
    Weak /* = 3 */
}

external interface ShellQuotedString {
    var value: String
    var quoting: ShellQuoting
}

external open class ShellExecution {
    constructor(commandLine: String, options: ShellExecutionOptions = definedExternally)
    constructor(commandLine: String)
    constructor(command: String, args: Array<Any /* String | ShellQuotedString */>, options: ShellExecutionOptions = definedExternally)
    constructor(command: String, args: Array<Any /* String | ShellQuotedString */>)
    constructor(command: ShellQuotedString, args: Array<Any /* String | ShellQuotedString */>, options: ShellExecutionOptions = definedExternally)
    constructor(command: ShellQuotedString, args: Array<Any /* String | ShellQuotedString */>)
    open var commandLine: String?
    open var command: dynamic /* String | ShellQuotedString */
    open var args: Array<dynamic /* String | ShellQuotedString */>
    open var options: ShellExecutionOptions
}

external open class CustomExecution(callback: (resolvedDefinition: TaskDefinition) -> Thenable<Pseudoterminal>)

external enum class TaskScope {
    Global /* = 1 */,
    Workspace /* = 2 */
}

external interface RunOptions {
    var reevaluateOnRerun: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external open class Task {
    constructor(taskDefinition: TaskDefinition, scope: WorkspaceFolder, name: String, source: String, execution: ProcessExecution = definedExternally, problemMatchers: Any = definedExternally)
    constructor(taskDefinition: TaskDefinition, scope: WorkspaceFolder, name: String, source: String)
    constructor(taskDefinition: TaskDefinition, scope: WorkspaceFolder, name: String, source: String, execution: ProcessExecution = definedExternally)
    constructor(taskDefinition: TaskDefinition, scope: WorkspaceFolder, name: String, source: String, execution: ShellExecution = definedExternally, problemMatchers: Any = definedExternally)
    constructor(taskDefinition: TaskDefinition, scope: WorkspaceFolder, name: String, source: String, execution: ShellExecution = definedExternally)
    constructor(taskDefinition: TaskDefinition, scope: WorkspaceFolder, name: String, source: String, execution: CustomExecution = definedExternally, problemMatchers: Any = definedExternally)
    constructor(taskDefinition: TaskDefinition, scope: WorkspaceFolder, name: String, source: String, execution: CustomExecution = definedExternally)
    constructor(taskDefinition: TaskDefinition, scope: TaskScope, name: String, source: String, execution: ProcessExecution = definedExternally, problemMatchers: Any = definedExternally)
    constructor(taskDefinition: TaskDefinition, scope: TaskScope, name: String, source: String)
    constructor(taskDefinition: TaskDefinition, scope: TaskScope, name: String, source: String, execution: ProcessExecution = definedExternally)
    constructor(taskDefinition: TaskDefinition, scope: TaskScope, name: String, source: String, execution: ShellExecution = definedExternally, problemMatchers: Any = definedExternally)
    constructor(taskDefinition: TaskDefinition, scope: TaskScope, name: String, source: String, execution: ShellExecution = definedExternally)
    constructor(taskDefinition: TaskDefinition, scope: TaskScope, name: String, source: String, execution: CustomExecution = definedExternally, problemMatchers: Any = definedExternally)
    constructor(taskDefinition: TaskDefinition, scope: TaskScope, name: String, source: String, execution: CustomExecution = definedExternally)
    constructor(taskDefinition: TaskDefinition, name: String, source: String, execution: ProcessExecution = definedExternally, problemMatchers: String = definedExternally)
    constructor(taskDefinition: TaskDefinition, name: String, source: String)
    constructor(taskDefinition: TaskDefinition, name: String, source: String, execution: ProcessExecution = definedExternally)
    constructor(taskDefinition: TaskDefinition, name: String, source: String, execution: ProcessExecution = definedExternally, problemMatchers: Array<String> = definedExternally)
    constructor(taskDefinition: TaskDefinition, name: String, source: String, execution: ShellExecution = definedExternally, problemMatchers: String = definedExternally)
    constructor(taskDefinition: TaskDefinition, name: String, source: String, execution: ShellExecution = definedExternally)
    constructor(taskDefinition: TaskDefinition, name: String, source: String, execution: ShellExecution = definedExternally, problemMatchers: Array<String> = definedExternally)
    open var definition: TaskDefinition
    open var scope: dynamic /* TaskScope.Global | TaskScope.Workspace | WorkspaceFolder */
    open var name: String
    open var detail: String
    open var execution: dynamic /* ProcessExecution | ShellExecution | CustomExecution */
    open var isBackground: Boolean
    open var source: String
    open var group: TaskGroup
    open var presentationOptions: TaskPresentationOptions
    open var problemMatchers: Array<String>
    open var runOptions: RunOptions
}

external interface TaskProvider<T : Task> {
    fun provideTasks(token: CancellationToken): dynamic /* Array<T>? | Thenable<Array<T>?>? */
    fun resolveTask(task: T, token: CancellationToken): dynamic /* T? | Thenable<T?>? */
}

external interface TaskProvider__0 : TaskProvider<Task>

external interface TaskExecution {
    var task: Task
    fun terminate()
}

external interface TaskStartEvent {
    var execution: TaskExecution
}

external interface TaskEndEvent {
    var execution: TaskExecution
}

external interface TaskProcessStartEvent {
    var execution: TaskExecution
    var processId: Number
}

external interface TaskProcessEndEvent {
    var execution: TaskExecution
    var exitCode: Number?
}

external interface TaskFilter {
    var version: String?
        get() = definedExternally
        set(value) = definedExternally
    var type: String?
        get() = definedExternally
        set(value) = definedExternally
}

external enum class FileType {
    Unknown /* = 0 */,
    File /* = 1 */,
    Directory /* = 2 */,
    SymbolicLink /* = 64 */
}

external interface FileStat {
    var type: FileType
    var ctime: Number
    var mtime: Number
    var size: Number
}

external enum class FileChangeType {
    Changed /* = 1 */,
    Created /* = 2 */,
    Deleted /* = 3 */
}

external interface FileChangeEvent {
    var type: FileChangeType
    var uri: Uri
}

external interface `T$28` {
    var recursive: Boolean
    var excludes: Array<String>
}

external interface `T$29` {
    var create: Boolean
    var overwrite: Boolean
}

external interface `T$30` {
    var recursive: Boolean
}

external interface `T$31` {
    var overwrite: Boolean
}

external interface FileSystemProvider {
    var onDidChangeFile: Event<Array<FileChangeEvent>>
    fun watch(uri: Uri, options: `T$28`): Disposable
    fun stat(uri: Uri): dynamic /* FileStat | Thenable<FileStat> */
    fun readDirectory(uri: Uri): dynamic /* Array<dynamic /* JsTuple<String, FileType> */> | Thenable<Array<dynamic /* JsTuple<String, FileType> */>> */
    fun createDirectory(uri: Uri): dynamic /* Unit | Thenable<Unit> */
    fun readFile(uri: Uri): dynamic /* Uint8Array | Thenable<Uint8Array> */
    fun writeFile(uri: Uri, content: Uint8Array, options: `T$29`): dynamic /* Unit | Thenable<Unit> */
    fun delete(uri: Uri, options: `T$30`): dynamic /* Unit | Thenable<Unit> */
    fun rename(oldUri: Uri, newUri: Uri, options: `T$31`): dynamic /* Unit | Thenable<Unit> */
    val copy: ((source: Uri, destination: Uri, options: `T$31`) -> dynamic)?
}

external interface `T$32` {
    var recursive: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var useTrash: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$33` {
    var overwrite: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface FileSystem {
    fun stat(uri: Uri): Thenable<FileStat>
    fun readDirectory(uri: Uri): Thenable<Array<dynamic /* JsTuple<String, FileType> */>>
    fun createDirectory(uri: Uri): Thenable<Unit>
    fun readFile(uri: Uri): Thenable<Uint8Array>
    fun writeFile(uri: Uri, content: Uint8Array): Thenable<Unit>
    fun delete(uri: Uri, options: `T$32` = definedExternally): Thenable<Unit>
    fun rename(source: Uri, target: Uri, options: `T$33` = definedExternally): Thenable<Unit>
    fun copy(source: Uri, target: Uri, options: `T$33` = definedExternally): Thenable<Unit>
    fun isWritableFileSystem(scheme: String): Boolean?
}

external interface WebviewPortMapping {
    var webviewPort: Number
    var extensionHostPort: Number
}

external interface WebviewOptions {
    var enableScripts: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var enableCommandUris: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var localResourceRoots: Array<Uri>?
        get() = definedExternally
        set(value) = definedExternally
    var portMapping: Array<WebviewPortMapping>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface Webview {
    var options: WebviewOptions
    var html: String
    var onDidReceiveMessage: Event<Any>
    fun postMessage(message: Any): Thenable<Boolean>
    fun asWebviewUri(localResource: Uri): Uri
    var cspSource: String
}

external interface WebviewPanelOptions {
    var enableFindWidget: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var retainContextWhenHidden: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface WebviewPanel {
    var viewType: String
    var title: String
    var iconPath: dynamic /* Uri? | `T$12`? */
        get() = definedExternally
        set(value) = definedExternally
    var webview: Webview
    var options: WebviewPanelOptions
    var viewColumn: ViewColumn?
        get() = definedExternally
        set(value) = definedExternally
    var active: Boolean
    var visible: Boolean
    var onDidChangeViewState: Event<WebviewPanelOnDidChangeViewStateEvent>
    var onDidDispose: Event<Unit>
    fun reveal(viewColumn: ViewColumn = definedExternally, preserveFocus: Boolean = definedExternally)
    fun dispose(): Any
}

external interface WebviewPanelOnDidChangeViewStateEvent {
    var webviewPanel: WebviewPanel
}

external interface WebviewPanelSerializer<T> {
    fun deserializeWebviewPanel(webviewPanel: WebviewPanel, state: T): Thenable<Unit>
}

external interface WebviewPanelSerializer__0 : WebviewPanelSerializer<Any>

external interface WebviewView {
    var viewType: String
    var webview: Webview
    var title: String?
        get() = definedExternally
        set(value) = definedExternally
    var description: String?
        get() = definedExternally
        set(value) = definedExternally
    var onDidDispose: Event<Unit>
    var visible: Boolean
    var onDidChangeVisibility: Event<Unit>
    fun show(preserveFocus: Boolean = definedExternally)
}

external interface WebviewViewResolveContext<T> {
    var state: T?
}

external interface WebviewViewResolveContext__0 : WebviewViewResolveContext<Any>

external interface WebviewViewProvider {
    fun resolveWebviewView(webviewView: WebviewView, context: WebviewViewResolveContext__0, token: CancellationToken): dynamic /* Thenable<Unit> | Unit */
}

external interface CustomTextEditorProvider {
    fun resolveCustomTextEditor(document: TextDocument, webviewPanel: WebviewPanel, token: CancellationToken): dynamic /* Thenable<Unit> | Unit */
}

external interface CustomDocument {
    var uri: Uri
    fun dispose()
}

external interface CustomDocumentEditEvent<T : CustomDocument> {
    var document: T
    fun undo(): dynamic /* Thenable<Unit> | Unit */
    fun redo(): dynamic /* Thenable<Unit> | Unit */
    var label: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface CustomDocumentContentChangeEvent<T : CustomDocument> {
    var document: T
}

external interface CustomDocumentBackup {
    var id: String
    fun delete()
}

external interface CustomDocumentBackupContext {
    var destination: Uri
}

external interface CustomDocumentOpenContext {
    var backupId: String?
        get() = definedExternally
        set(value) = definedExternally
    var untitledDocumentData: Uint8Array?
        get() = definedExternally
        set(value) = definedExternally
}

external interface CustomReadonlyEditorProvider<T : CustomDocument> {
    fun openCustomDocument(uri: Uri, openContext: CustomDocumentOpenContext, token: CancellationToken): dynamic /* Thenable<T> | T */
    fun resolveCustomEditor(document: T, webviewPanel: WebviewPanel, token: CancellationToken): dynamic /* Thenable<Unit> | Unit */
}

external interface CustomReadonlyEditorProvider__0 : CustomReadonlyEditorProvider<CustomDocument>

external interface CustomEditorProvider<T : CustomDocument> : CustomReadonlyEditorProvider<T> {
    var onDidChangeCustomDocument: dynamic /* Event<CustomDocumentEditEvent<T>> | Event<CustomDocumentContentChangeEvent<T>> */
        get() = definedExternally
        set(value) = definedExternally
    fun saveCustomDocument(document: T, cancellation: CancellationToken): Thenable<Unit>
    fun saveCustomDocumentAs(document: T, destination: Uri, cancellation: CancellationToken): Thenable<Unit>
    fun revertCustomDocument(document: T, cancellation: CancellationToken): Thenable<Unit>
    fun backupCustomDocument(document: T, context: CustomDocumentBackupContext, cancellation: CancellationToken): Thenable<CustomDocumentBackup>
}

external interface CustomEditorProvider__0 : CustomEditorProvider<CustomDocument>

external interface Clipboard {
    fun readText(): Thenable<String>
    fun writeText(value: String): Thenable<Unit>
}

external enum class UIKind {
    Desktop /* = 1 */,
    Web /* = 2 */
}

external interface WindowState {
    var focused: Boolean
}

external interface UriHandler {
    fun handleUri(uri: Uri): dynamic /* Unit? | Thenable<Unit?>? */
}

external interface TreeViewOptions<T> {
    var treeDataProvider: TreeDataProvider<T>
    var showCollapseAll: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var canSelectMany: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface TreeViewExpansionEvent<T> {
    var element: T
}

external interface TreeViewSelectionChangeEvent<T> {
    var selection: Array<T>
}

external interface TreeViewVisibilityChangeEvent {
    var visible: Boolean
}

external interface `T$40` {
    var select: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var focus: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var expand: dynamic /* Boolean? | Number? */
        get() = definedExternally
        set(value) = definedExternally
}

external interface TreeView<T> : Disposable {
    var onDidExpandElement: Event<TreeViewExpansionEvent<T>>
    var onDidCollapseElement: Event<TreeViewExpansionEvent<T>>
    var selection: Array<T>
    var onDidChangeSelection: Event<TreeViewSelectionChangeEvent<T>>
    var visible: Boolean
    var onDidChangeVisibility: Event<TreeViewVisibilityChangeEvent>
    var message: String?
        get() = definedExternally
        set(value) = definedExternally
    var title: String?
        get() = definedExternally
        set(value) = definedExternally
    var description: String?
        get() = definedExternally
        set(value) = definedExternally
    fun reveal(element: T, options: `T$40` = definedExternally): Thenable<Unit>
}

external interface TreeDataProvider<T> {
    var onDidChangeTreeData: Event<dynamic /* T? | Unit? */>?
        get() = definedExternally
        set(value) = definedExternally
    fun getTreeItem(element: T): dynamic /* TreeItem | Thenable<TreeItem> */
    fun getChildren(element: T = definedExternally): dynamic /* Array<T>? | Thenable<Array<T>?>? */
    val getParent: ((element: T) -> dynamic)?
    val resolveTreeItem: ((item: TreeItem, element: T, token: CancellationToken) -> dynamic)?
}

external interface `T$41` {
    var light: dynamic /* String | Uri */
        get() = definedExternally
        set(value) = definedExternally
    var dark: dynamic /* String | Uri */
        get() = definedExternally
        set(value) = definedExternally
}

external open class TreeItem {
    open var label: dynamic /* String | TreeItemLabel */
    open var id: String
    open var iconPath: dynamic /* String | Uri | `T$41` | ThemeIcon */
    open var description: dynamic /* String | Boolean */
    open var resourceUri: Uri
    open var tooltip: dynamic /* String? | MarkdownString? */
    open var command: Command
    open var collapsibleState: TreeItemCollapsibleState
    open var contextValue: String
    open var accessibilityInformation: AccessibilityInformation
    constructor(label: String, collapsibleState: TreeItemCollapsibleState = definedExternally)
    constructor(label: String)
    constructor(label: TreeItemLabel, collapsibleState: TreeItemCollapsibleState = definedExternally)
    constructor(label: TreeItemLabel)
    constructor(resourceUri: Uri, collapsibleState: TreeItemCollapsibleState = definedExternally)
    constructor(resourceUri: Uri)
}

external enum class TreeItemCollapsibleState {
    None /* = 0 */,
    Collapsed /* = 1 */,
    Expanded /* = 2 */
}

external interface TreeItemLabel {
    var label: String
    var highlights: Array<dynamic /* JsTuple<Number, Number> */>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$42` {
    @nativeGetter
    operator fun get(key: String): String?
    @nativeSetter
    operator fun set(key: String, value: String?)
}

external interface TerminalOptions {
    var name: String?
        get() = definedExternally
        set(value) = definedExternally
    var shellPath: String?
        get() = definedExternally
        set(value) = definedExternally
    var shellArgs: dynamic /* Array<String>? | String? */
        get() = definedExternally
        set(value) = definedExternally
    var cwd: dynamic /* String? | Uri? */
        get() = definedExternally
        set(value) = definedExternally
    var env: `T$42`?
        get() = definedExternally
        set(value) = definedExternally
    var strictEnv: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var hideFromUser: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var message: String?
        get() = definedExternally
        set(value) = definedExternally
    var iconPath: dynamic /* Uri? | `T$12`? | ThemeIcon? */
        get() = definedExternally
        set(value) = definedExternally
    var color: ThemeColor?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ExtensionTerminalOptions {
    var name: String
    var pty: Pseudoterminal
    var iconPath: dynamic /* Uri? | `T$12`? | ThemeIcon? */
        get() = definedExternally
        set(value) = definedExternally
    var color: ThemeColor?
        get() = definedExternally
        set(value) = definedExternally
}

external interface Pseudoterminal {
    var onDidWrite: Event<String>
    var onDidOverrideDimensions: Event<TerminalDimensions?>?
        get() = definedExternally
        set(value) = definedExternally
    var onDidClose: Event<dynamic /* Unit | Number */>?
        get() = definedExternally
        set(value) = definedExternally
    var onDidChangeName: Event<String>?
        get() = definedExternally
        set(value) = definedExternally
    fun open(initialDimensions: TerminalDimensions?)
    fun close()
    val handleInput: ((data: String) -> Unit)?
    val setDimensions: ((dimensions: TerminalDimensions) -> Unit)?
}

external interface TerminalDimensions {
    var columns: Number
    var rows: Number
}

external interface TerminalExitStatus {
    var code: Number?
}

external enum class EnvironmentVariableMutatorType {
    Replace /* = 1 */,
    Append /* = 2 */,
    Prepend /* = 3 */
}

external interface EnvironmentVariableMutator {
    var type: EnvironmentVariableMutatorType
    var value: String
}

external interface EnvironmentVariableCollection {
    var persistent: Boolean
    fun replace(variable: String, value: String)
    fun append(variable: String, value: String)
    fun prepend(variable: String, value: String)
    fun get(variable: String): EnvironmentVariableMutator?
    fun forEach(callback: (variable: String, mutator: EnvironmentVariableMutator, collection: EnvironmentVariableCollection) -> Any, thisArg: Any = definedExternally)
    fun delete(variable: String)
    fun clear()
}

external enum class ProgressLocation {
    SourceControl /* = 1 */,
    Window /* = 10 */,
    Notification /* = 15 */
}

external interface `T$43` {
    var viewId: String
}

external interface ProgressOptions {
    var location: dynamic /* ProgressLocation | `T$43` */
        get() = definedExternally
        set(value) = definedExternally
    var title: String?
        get() = definedExternally
        set(value) = definedExternally
    var cancellable: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface QuickInput {
    var title: String?
    var step: Number?
    var totalSteps: Number?
    var enabled: Boolean
    var busy: Boolean
    var ignoreFocusOut: Boolean
    fun show()
    fun hide()
    var onDidHide: Event<Unit>
    fun dispose()
}

external interface QuickPick<T : QuickPickItem> : QuickInput {
    var value: String
    var placeholder: String?
    var onDidChangeValue: Event<String>
    var onDidAccept: Event<Unit>
    var buttons: Array<QuickInputButton>
    var onDidTriggerButton: Event<QuickInputButton>
    var items: Array<T>
    var canSelectMany: Boolean
    var matchOnDescription: Boolean
    var matchOnDetail: Boolean
    var activeItems: Array<T>
    var onDidChangeActive: Event<Array<T>>
    var selectedItems: Array<T>
    var onDidChangeSelection: Event<Array<T>>
}

external interface InputBox : QuickInput {
    var value: String
    var placeholder: String?
    var password: Boolean
    var onDidChangeValue: Event<String>
    var onDidAccept: Event<Unit>
    var buttons: Array<QuickInputButton>
    var onDidTriggerButton: Event<QuickInputButton>
    var prompt: String?
    var validationMessage: String?
}

external interface QuickInputButton {
    var iconPath: dynamic /* Uri | `T$12` | ThemeIcon */
        get() = definedExternally
        set(value) = definedExternally
    var tooltip: String?
        get() = definedExternally
        set(value) = definedExternally
}

external open class QuickInputButtons {
    companion object {
        var Back: QuickInputButton
    }
}

external interface TextDocumentContentChangeEvent {
    var range: Range
    var rangeOffset: Number
    var rangeLength: Number
    var text: String
}

external enum class TextDocumentChangeReason {
    Undo /* = 1 */,
    Redo /* = 2 */
}

external interface TextDocumentChangeEvent {
    var document: TextDocument
    var contentChanges: Array<TextDocumentContentChangeEvent>
    var reason: TextDocumentChangeReason?
        get() = definedExternally
        set(value) = definedExternally
}

external enum class TextDocumentSaveReason {
    Manual /* = 1 */,
    AfterDelay /* = 2 */,
    FocusOut /* = 3 */
}

external interface TextDocumentWillSaveEvent {
    var document: TextDocument
    var reason: TextDocumentSaveReason
    fun waitUntil(thenable: Thenable<Array<TextEdit>>)
    fun waitUntil(thenable: Thenable<Any>)
}

external interface FileWillCreateEvent {
    var files: Array<Uri>
    fun waitUntil(thenable: Thenable<WorkspaceEdit>)
    fun waitUntil(thenable: Thenable<Any>)
}

external interface FileCreateEvent {
    var files: Array<Uri>
}

external interface FileWillDeleteEvent {
    var files: Array<Uri>
    fun waitUntil(thenable: Thenable<WorkspaceEdit>)
    fun waitUntil(thenable: Thenable<Any>)
}

external interface FileDeleteEvent {
    var files: Array<Uri>
}

external interface `T$44` {
    var oldUri: Uri
    var newUri: Uri
}

external interface FileWillRenameEvent {
    var files: Array<`T$44`>
    fun waitUntil(thenable: Thenable<WorkspaceEdit>)
    fun waitUntil(thenable: Thenable<Any>)
}

external interface FileRenameEvent {
    var files: Array<`T$44`>
}

external interface WorkspaceFoldersChangeEvent {
    var added: Array<WorkspaceFolder>
    var removed: Array<WorkspaceFolder>
}

external interface WorkspaceFolder {
    var uri: Uri
    var name: String
    var index: Number
}

external interface `T$48` {
    var uri: Uri?
        get() = definedExternally
        set(value) = definedExternally
    var languageId: String
}

external interface ConfigurationChangeEvent {
    fun affectsConfiguration(section: String, scope: Uri = definedExternally): Boolean
    fun affectsConfiguration(section: String): Boolean
    fun affectsConfiguration(section: String, scope: TextDocument = definedExternally): Boolean
    fun affectsConfiguration(section: String, scope: WorkspaceFolder = definedExternally): Boolean
    fun affectsConfiguration(section: String, scope: `T$48` = definedExternally): Boolean
}

external enum class NotebookCellKind {
    Markup /* = 1 */,
    Code /* = 2 */
}

external interface NotebookCell {
    var index: Number
    var notebook: NotebookDocument
    var kind: NotebookCellKind
    var document: TextDocument
    var metadata: Json
    var outputs: Array<NotebookCellOutput>
    var executionSummary: NotebookCellExecutionSummary?
        get() = definedExternally
        set(value) = definedExternally
}

external interface NotebookEditor

external interface `T$49` {
    var editor: NotebookEditor
    var message: Any
}

external interface NotebookRendererMessaging {
    var onDidReceiveMessage: Event<`T$49`>
    fun postMessage(message: Any, editor: NotebookEditor = definedExternally): Thenable<Boolean>
}

external interface NotebookDocument {
    var uri: Uri
    var notebookType: String
    var version: Number
    var isDirty: Boolean
    var isUntitled: Boolean
    var isClosed: Boolean
    var metadata: Json
    var cellCount: Number
    fun cellAt(index: Number): NotebookCell
    fun getCells(range: NotebookRange = definedExternally): Array<NotebookCell>
    fun save(): Thenable<Boolean>
}

external interface `T$50` {
    var startTime: Number
    var endTime: Number
}

external interface NotebookCellExecutionSummary {
    var executionOrder: Number?
        get() = definedExternally
        set(value) = definedExternally
    var success: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var timing: `T$50`?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$51` {
    var start: Number?
        get() = definedExternally
        set(value) = definedExternally
    var end: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external open class NotebookRange(start: Number, end: Number) {
    open var start: Number
    open var end: Number
    open var isEmpty: Boolean
    open fun with(change: `T$51`): NotebookRange
}

external open class NotebookCellOutputItem(data: Uint8Array, mime: String) {
    open var mime: String
    open var data: Uint8Array

    companion object {
        fun text(value: String, mime: String = definedExternally): NotebookCellOutputItem
        fun json(value: Any, mime: String = definedExternally): NotebookCellOutputItem
        fun stdout(value: String): NotebookCellOutputItem
        fun stderr(value: String): NotebookCellOutputItem
        fun error(value: Error): NotebookCellOutputItem
    }
}

external open class NotebookCellOutput(items: Array<NotebookCellOutputItem>, metadata: Json = definedExternally) {
    open var items: Array<NotebookCellOutputItem>
    open var metadata: Json
}

external open class NotebookCellData(kind: NotebookCellKind, value: String, languageId: String) {
    open var kind: NotebookCellKind
    open var value: String
    open var languageId: String
    open var outputs: Array<NotebookCellOutput>
    open var metadata: Json
    open var executionSummary: NotebookCellExecutionSummary
}

external open class NotebookData(cells: Array<NotebookCellData>) {
    open var cells: Array<NotebookCellData>
    open var metadata: Json
}

external interface NotebookSerializer {
    fun deserializeNotebook(content: Uint8Array, token: CancellationToken): dynamic /* NotebookData | Thenable<NotebookData> */
    fun serializeNotebook(data: NotebookData, token: CancellationToken): dynamic /* Uint8Array | Thenable<Uint8Array> */
}

external interface `T$52` {
    @nativeGetter
    operator fun get(key: String): Boolean?
    @nativeSetter
    operator fun set(key: String, value: Boolean?)
}

external interface NotebookDocumentContentOptions {
    var transientOutputs: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var transientCellMetadata: `T$52`?
        get() = definedExternally
        set(value) = definedExternally
    var transientDocumentMetadata: `T$52`?
        get() = definedExternally
        set(value) = definedExternally
}

external enum class NotebookControllerAffinity {
    Default /* = 1 */,
    Preferred /* = 2 */
}

external interface `T$53` {
    var notebook: NotebookDocument
    var selected: Boolean
}

external interface NotebookController {
    var id: String
    var notebookType: String
    var supportedLanguages: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
    var label: String
    var description: String?
        get() = definedExternally
        set(value) = definedExternally
    var detail: String?
        get() = definedExternally
        set(value) = definedExternally
    var supportsExecutionOrder: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    fun createNotebookCellExecution(cell: NotebookCell): NotebookCellExecution
    var executeHandler: (cells: Array<NotebookCell>, notebook: NotebookDocument, controller: NotebookController) -> dynamic
    var interruptHandler: ((notebook: NotebookDocument) -> dynamic)?
        get() = definedExternally
        set(value) = definedExternally
    var onDidChangeSelectedNotebooks: Event<`T$53`>
    fun updateNotebookAffinity(notebook: NotebookDocument, affinity: NotebookControllerAffinity)
    fun dispose()
}

external interface NotebookCellExecution {
    var cell: NotebookCell
    var token: CancellationToken
    var executionOrder: Number?
    fun start(startTime: Number = definedExternally)
    fun end(success: Boolean?, endTime: Number = definedExternally)
    fun clearOutput(cell: NotebookCell = definedExternally): Thenable<Unit>
    fun replaceOutput(out: NotebookCellOutput, cell: NotebookCell = definedExternally): Thenable<Unit>
    fun replaceOutput(out: NotebookCellOutput): Thenable<Unit>
    fun replaceOutput(out: Array<NotebookCellOutput>, cell: NotebookCell = definedExternally): Thenable<Unit>
    fun replaceOutput(out: Array<NotebookCellOutput>): Thenable<Unit>
    fun appendOutput(out: NotebookCellOutput, cell: NotebookCell = definedExternally): Thenable<Unit>
    fun appendOutput(out: NotebookCellOutput): Thenable<Unit>
    fun appendOutput(out: Array<NotebookCellOutput>, cell: NotebookCell = definedExternally): Thenable<Unit>
    fun appendOutput(out: Array<NotebookCellOutput>): Thenable<Unit>
    fun replaceOutputItems(items: NotebookCellOutputItem, output: NotebookCellOutput): Thenable<Unit>
    fun replaceOutputItems(items: Array<NotebookCellOutputItem>, output: NotebookCellOutput): Thenable<Unit>
    fun appendOutputItems(items: NotebookCellOutputItem, output: NotebookCellOutput): Thenable<Unit>
    fun appendOutputItems(items: Array<NotebookCellOutputItem>, output: NotebookCellOutput): Thenable<Unit>
}

external enum class NotebookCellStatusBarAlignment {
    Left /* = 1 */,
    Right /* = 2 */
}

external open class NotebookCellStatusBarItem(text: String, alignment: NotebookCellStatusBarAlignment) {
    open var text: String
    open var alignment: NotebookCellStatusBarAlignment
    open var command: dynamic /* String | Command */
    open var tooltip: String
    open var priority: Number
    open var accessibilityInformation: AccessibilityInformation
}

external interface NotebookCellStatusBarItemProvider {
    var onDidChangeCellStatusBarItems: Event<Unit>?
        get() = definedExternally
        set(value) = definedExternally
    fun provideCellStatusBarItems(cell: NotebookCell, token: CancellationToken): dynamic /* NotebookCellStatusBarItem? | Array<NotebookCellStatusBarItem>? | Thenable<dynamic /* NotebookCellStatusBarItem? | Array<NotebookCellStatusBarItem>? */>? */
}

external interface SourceControlInputBox {
    var value: String
    var placeholder: String
    var visible: Boolean
}

external interface QuickDiffProvider {
    val provideOriginalResource: ((uri: Uri, token: CancellationToken) -> dynamic)?
}

external interface SourceControlResourceThemableDecorations {
    var iconPath: dynamic /* String? | Uri? | ThemeIcon? */
        get() = definedExternally
        set(value) = definedExternally
}

external interface SourceControlResourceDecorations : SourceControlResourceThemableDecorations {
    var strikeThrough: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var faded: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var tooltip: String?
        get() = definedExternally
        set(value) = definedExternally
    var light: SourceControlResourceThemableDecorations?
        get() = definedExternally
        set(value) = definedExternally
    var dark: SourceControlResourceThemableDecorations?
        get() = definedExternally
        set(value) = definedExternally
}

external interface SourceControlResourceState {
    var resourceUri: Uri
    var command: Command?
        get() = definedExternally
        set(value) = definedExternally
    var decorations: SourceControlResourceDecorations?
        get() = definedExternally
        set(value) = definedExternally
    var contextValue: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface SourceControlResourceGroup {
    var id: String
    var label: String
    var hideWhenEmpty: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var resourceStates: Array<SourceControlResourceState>
    fun dispose()
}

external interface SourceControl {
    var id: String
    var label: String
    var rootUri: Uri?
    var inputBox: SourceControlInputBox
    var count: Number?
        get() = definedExternally
        set(value) = definedExternally
    var quickDiffProvider: QuickDiffProvider?
        get() = definedExternally
        set(value) = definedExternally
    var commitTemplate: String?
        get() = definedExternally
        set(value) = definedExternally
    var acceptInputCommand: Command?
        get() = definedExternally
        set(value) = definedExternally
    var statusBarCommands: Array<Command>?
        get() = definedExternally
        set(value) = definedExternally
    fun createResourceGroup(id: String, label: String): SourceControlResourceGroup
    fun dispose()
}

external interface DebugProtocolMessage

external interface DebugProtocolSource

external interface DebugProtocolBreakpoint

external interface DebugConfiguration {
    var type: String
    var name: String
    var request: String
    @nativeGetter
    operator fun get(key: String): Any?
    @nativeSetter
    operator fun set(key: String, value: Any)
}

external interface DebugSession {
    var id: String
    var type: String
    var parentSession: DebugSession?
        get() = definedExternally
        set(value) = definedExternally
    var name: String
    var workspaceFolder: WorkspaceFolder?
    var configuration: DebugConfiguration
    fun customRequest(command: String, args: Any = definedExternally): Thenable<Any>
    fun getDebugProtocolBreakpoint(breakpoint: Breakpoint): Thenable<DebugProtocolBreakpoint?>
}

external interface DebugSessionCustomEvent {
    var session: DebugSession
    var event: String
    var body: Any?
        get() = definedExternally
        set(value) = definedExternally
}

external interface DebugConfigurationProvider {
    val provideDebugConfigurations: ((folder: WorkspaceFolder?, token: CancellationToken) -> dynamic)?
    val resolveDebugConfiguration: ((folder: WorkspaceFolder?, debugConfiguration: DebugConfiguration, token: CancellationToken) -> dynamic)?
    val resolveDebugConfigurationWithSubstitutedVariables: ((folder: WorkspaceFolder?, debugConfiguration: DebugConfiguration, token: CancellationToken) -> dynamic)?
}

external open class DebugAdapterExecutable(command: String, args: Array<String> = definedExternally, options: DebugAdapterExecutableOptions = definedExternally) {
    open var command: String
    open var args: Array<String>
    open var options: DebugAdapterExecutableOptions
}

external interface DebugAdapterExecutableOptions {
    var env: `T$26`?
        get() = definedExternally
        set(value) = definedExternally
    var cwd: String?
        get() = definedExternally
        set(value) = definedExternally
}

external open class DebugAdapterServer(port: Number, host: String = definedExternally) {
    open var port: Number
    open var host: String
}

external open class DebugAdapterNamedPipeServer(path: String) {
    open var path: String
}

external interface DebugAdapter : Disposable {
    var onDidSendMessage: Event<DebugProtocolMessage>
    fun handleMessage(message: DebugProtocolMessage)
}

external open class DebugAdapterInlineImplementation(implementation: DebugAdapter)

external interface DebugAdapterDescriptorFactory {
    fun createDebugAdapterDescriptor(session: DebugSession, executable: DebugAdapterExecutable?): dynamic /* DebugAdapterExecutable? | DebugAdapterServer? | DebugAdapterNamedPipeServer? | DebugAdapterInlineImplementation? | Thenable<dynamic /* DebugAdapterExecutable? | DebugAdapterServer? | DebugAdapterNamedPipeServer? | DebugAdapterInlineImplementation? */>? */
}

external interface DebugAdapterTracker {
    val onWillStartSession: (() -> Unit)?
    val onWillReceiveMessage: ((message: Any) -> Unit)?
    val onDidSendMessage: ((message: Any) -> Unit)?
    val onWillStopSession: (() -> Unit)?
    val onError: ((error: Error) -> Unit)?
    val onExit: ((code: Number?, signal: String?) -> Unit)?
}

external interface DebugAdapterTrackerFactory {
    fun createDebugAdapterTracker(session: DebugSession): dynamic /* DebugAdapterTracker? | Thenable<DebugAdapterTracker?>? */
}

external interface DebugConsole {
    fun append(value: String)
    fun appendLine(value: String)
}

external interface BreakpointsChangeEvent {
    var added: Array<Breakpoint>
    var removed: Array<Breakpoint>
    var changed: Array<Breakpoint>
}

external open class Breakpoint(enabled: Boolean = definedExternally, condition: String = definedExternally, hitCondition: String = definedExternally, logMessage: String = definedExternally) {
    open var id: String
    open var enabled: Boolean
    open var condition: String
    open var hitCondition: String
    open var logMessage: String
}

external open class SourceBreakpoint(location: Location, enabled: Boolean = definedExternally, condition: String = definedExternally, hitCondition: String = definedExternally, logMessage: String = definedExternally) : Breakpoint {
    open var location: Location
}

external open class FunctionBreakpoint(functionName: String, enabled: Boolean = definedExternally, condition: String = definedExternally, hitCondition: String = definedExternally, logMessage: String = definedExternally) : Breakpoint {
    open var functionName: String
}

external enum class DebugConsoleMode {
    Separate /* = 0 */,
    MergeWithParent /* = 1 */
}

external interface DebugSessionOptions {
    var parentSession: DebugSession?
        get() = definedExternally
        set(value) = definedExternally
    var lifecycleManagedByParent: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var consoleMode: DebugConsoleMode?
        get() = definedExternally
        set(value) = definedExternally
    var noDebug: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var compact: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external enum class DebugConfigurationProviderTriggerKind {
    Initial /* = 1 */,
    Dynamic /* = 2 */
}

external enum class CommentThreadCollapsibleState {
    Collapsed /* = 0 */,
    Expanded /* = 1 */
}

external enum class CommentMode {
    Editing /* = 0 */,
    Preview /* = 1 */
}

external interface CommentThread {
    var uri: Uri
    var range: Range
    var comments: Array<Comment>
    var collapsibleState: CommentThreadCollapsibleState
    var canReply: Boolean
    var contextValue: String?
        get() = definedExternally
        set(value) = definedExternally
    var label: String?
        get() = definedExternally
        set(value) = definedExternally
    fun dispose()
}

external interface CommentAuthorInformation {
    var name: String
    var iconPath: Uri?
        get() = definedExternally
        set(value) = definedExternally
}

external interface CommentReaction {
    var label: String
    var iconPath: dynamic /* String | Uri */
        get() = definedExternally
        set(value) = definedExternally
    var count: Number
    var authorHasReacted: Boolean
}

external interface Comment {
    var body: dynamic /* String | MarkdownString */
        get() = definedExternally
        set(value) = definedExternally
    var mode: CommentMode
    var author: CommentAuthorInformation
    var contextValue: String?
        get() = definedExternally
        set(value) = definedExternally
    var reactions: Array<CommentReaction>?
        get() = definedExternally
        set(value) = definedExternally
    var label: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface CommentReply {
    var thread: CommentThread
    var text: String
}

external interface CommentingRangeProvider {
    fun provideCommentingRanges(document: TextDocument, token: CancellationToken): dynamic /* Array<Range>? | Thenable<Array<Range>?>? */
}

external interface CommentOptions {
    var prompt: String?
        get() = definedExternally
        set(value) = definedExternally
    var placeHolder: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface CommentController {
    var id: String
    var label: String
    var options: CommentOptions?
        get() = definedExternally
        set(value) = definedExternally
    var commentingRangeProvider: CommentingRangeProvider?
        get() = definedExternally
        set(value) = definedExternally
    fun createCommentThread(uri: Uri, range: Range, comments: Array<Comment>): CommentThread
    var reactionHandler: ((comment: Comment, reaction: CommentReaction) -> Thenable<Unit>)?
        get() = definedExternally
        set(value) = definedExternally
    fun dispose()
}

external interface AuthenticationSession {
    var id: String
    var accessToken: String
    var account: AuthenticationSessionAccountInformation
    var scopes: Array<String>
}

external interface AuthenticationSessionAccountInformation {
    var id: String
    var label: String
}

external interface AuthenticationGetSessionOptions {
    var createIfNone: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var clearSessionPreference: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface AuthenticationProviderInformation {
    var id: String
    var label: String
}

external interface AuthenticationSessionsChangeEvent {
    var provider: AuthenticationProviderInformation
}

external interface AuthenticationProviderOptions {
    var supportsMultipleAccounts: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface AuthenticationProviderAuthenticationSessionsChangeEvent {
    var added: Array<AuthenticationSession>?
        get() = definedExternally
        set(value) = definedExternally
    var removed: Array<AuthenticationSession>?
        get() = definedExternally
        set(value) = definedExternally
    var changed: Array<AuthenticationSession>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface AuthenticationProvider {
    var onDidChangeSessions: Event<AuthenticationProviderAuthenticationSessionsChangeEvent>
    fun getSessions(scopes: Array<String> = definedExternally): Thenable<Array<AuthenticationSession>>
    fun createSession(scopes: Array<String>): Thenable<AuthenticationSession>
    fun removeSession(sessionId: String): Thenable<Unit>
}

external enum class TestRunProfileKind {
    Run /* = 1 */,
    Debug /* = 2 */,
    Coverage /* = 3 */
}

external interface TestRunProfile {
    var label: String
    var kind: TestRunProfileKind
    var isDefault: Boolean
    var configureHandler: (() -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
    var runHandler: (request: TestRunRequest, token: CancellationToken) -> dynamic
    fun dispose()
}

external interface TestController {
    var id: String
    var label: String
    var items: TestItemCollection
    fun createRunProfile(label: String, kind: TestRunProfileKind, runHandler: (request: TestRunRequest, token: CancellationToken) -> Any, isDefault: Boolean = definedExternally): TestRunProfile
    var resolveHandler: ((item: TestItem?) -> dynamic)?
        get() = definedExternally
        set(value) = definedExternally
    fun createTestRun(request: TestRunRequest, name: String = definedExternally, persist: Boolean = definedExternally): TestRun
    fun createTestItem(id: String, label: String, uri: Uri = definedExternally): TestItem
    fun dispose()
}

external open class TestRunRequest(include: Array<TestItem> = definedExternally, exclude: Array<TestItem> = definedExternally, profile: TestRunProfile = definedExternally) {
    open var include: Array<TestItem>
    open var exclude: Array<TestItem>
    open var profile: TestRunProfile
}

external interface TestRun {
    var name: String?
        get() = definedExternally
        set(value) = definedExternally
    var token: CancellationToken
    var isPersisted: Boolean
    fun enqueued(test: TestItem)
    fun started(test: TestItem)
    fun skipped(test: TestItem)
    fun failed(test: TestItem, message: TestMessage, duration: Number = definedExternally)
    fun failed(test: TestItem, message: TestMessage)
    fun failed(test: TestItem, message: Array<TestMessage>, duration: Number = definedExternally)
    fun failed(test: TestItem, message: Array<TestMessage>)
    fun errored(test: TestItem, message: TestMessage, duration: Number = definedExternally)
    fun errored(test: TestItem, message: TestMessage)
    fun errored(test: TestItem, message: Array<TestMessage>, duration: Number = definedExternally)
    fun errored(test: TestItem, message: Array<TestMessage>)
    fun passed(test: TestItem, duration: Number = definedExternally)
    fun appendOutput(output: String)
    fun end()
}

external interface TestItemCollection {
    var size: Number
    fun replace(items: Array<TestItem>)
    fun forEach(callback: (item: TestItem, collection: TestItemCollection) -> Any, thisArg: Any = definedExternally)
    fun add(item: TestItem)
    fun delete(itemId: String)
    fun get(itemId: String): TestItem?
}

external interface TestItem {
    var id: String
    var uri: Uri?
        get() = definedExternally
        set(value) = definedExternally
    var children: TestItemCollection
    var parent: TestItem?
        get() = definedExternally
        set(value) = definedExternally
    var canResolveChildren: Boolean
    var busy: Boolean
    var label: String
    var description: String?
        get() = definedExternally
        set(value) = definedExternally
    var range: Range?
        get() = definedExternally
        set(value) = definedExternally
    var error: dynamic /* String? | MarkdownString? */
        get() = definedExternally
        set(value) = definedExternally
}

external open class TestMessage {
    open var message: dynamic /* String | MarkdownString */
    open var expectedOutput: String
    open var actualOutput: String
    open var location: Location
    constructor(message: String)
    constructor(message: MarkdownString)

    companion object {
        fun diff(message: String, expected: String, actual: String): TestMessage
        fun diff(message: MarkdownString, expected: String, actual: String): TestMessage
    }
}