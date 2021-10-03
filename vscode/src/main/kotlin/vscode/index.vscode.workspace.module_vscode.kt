@file:JsModule("vscode")
@file:JsNonModule
@file:JsQualifier("workspace")
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package vscode.workspace

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
import vscode.FileSystem
import vscode.WorkspaceFolder
import vscode.Uri
import vscode.Event
import vscode.WorkspaceFoldersChangeEvent
import vscode.FileSystemWatcher
import vscode.RelativePattern
import vscode.CancellationToken
import Thenable
import vscode.WorkspaceEdit
import vscode.TextDocument
import vscode.TextDocumentContentProvider
import vscode.Disposable
import vscode.TextDocumentChangeEvent
import vscode.TextDocumentWillSaveEvent
import vscode.NotebookDocument
import vscode.NotebookData
import vscode.NotebookSerializer
import vscode.NotebookDocumentContentOptions
import vscode.FileWillCreateEvent
import vscode.FileCreateEvent
import vscode.FileWillDeleteEvent
import vscode.FileDeleteEvent
import vscode.FileWillRenameEvent
import vscode.FileRenameEvent
import vscode.WorkspaceConfiguration
import vscode.`T$48`
import vscode.ConfigurationChangeEvent
import vscode.TaskProvider__0
import vscode.FileSystemProvider

external var fs: FileSystem

external var rootPath: String?

external var workspaceFolders: Array<WorkspaceFolder>?

external var name: String?

external var workspaceFile: Uri?

external var onDidChangeWorkspaceFolders: Event<WorkspaceFoldersChangeEvent>

external fun getWorkspaceFolder(uri: Uri): WorkspaceFolder?

external fun asRelativePath(pathOrUri: String, includeWorkspaceFolder: Boolean = definedExternally): String

external fun asRelativePath(pathOrUri: String): String

external fun asRelativePath(pathOrUri: Uri, includeWorkspaceFolder: Boolean = definedExternally): String

external fun asRelativePath(pathOrUri: Uri): String

external interface `T$45` {
    var uri: Uri
    var name: String?
        get() = definedExternally
        set(value) = definedExternally
}

external fun updateWorkspaceFolders(start: Number, deleteCount: Number?, vararg workspaceFoldersToAdd: `T$45`): Boolean

external fun createFileSystemWatcher(globPattern: String, ignoreCreateEvents: Boolean = definedExternally, ignoreChangeEvents: Boolean = definedExternally, ignoreDeleteEvents: Boolean = definedExternally): FileSystemWatcher

external fun createFileSystemWatcher(globPattern: String): FileSystemWatcher

external fun createFileSystemWatcher(globPattern: String, ignoreCreateEvents: Boolean = definedExternally): FileSystemWatcher

external fun createFileSystemWatcher(globPattern: String, ignoreCreateEvents: Boolean = definedExternally, ignoreChangeEvents: Boolean = definedExternally): FileSystemWatcher

external fun createFileSystemWatcher(globPattern: RelativePattern, ignoreCreateEvents: Boolean = definedExternally, ignoreChangeEvents: Boolean = definedExternally, ignoreDeleteEvents: Boolean = definedExternally): FileSystemWatcher

external fun createFileSystemWatcher(globPattern: RelativePattern): FileSystemWatcher

external fun createFileSystemWatcher(globPattern: RelativePattern, ignoreCreateEvents: Boolean = definedExternally): FileSystemWatcher

external fun createFileSystemWatcher(globPattern: RelativePattern, ignoreCreateEvents: Boolean = definedExternally, ignoreChangeEvents: Boolean = definedExternally): FileSystemWatcher

external fun findFiles(include: String, exclude: String? = definedExternally, maxResults: Number = definedExternally, token: CancellationToken = definedExternally): Thenable<Array<Uri>>

external fun findFiles(include: String): Thenable<Array<Uri>>

external fun findFiles(include: String, exclude: String? = definedExternally): Thenable<Array<Uri>>

external fun findFiles(include: String, exclude: String? = definedExternally, maxResults: Number = definedExternally): Thenable<Array<Uri>>

external fun findFiles(include: String, exclude: RelativePattern? = definedExternally, maxResults: Number = definedExternally, token: CancellationToken = definedExternally): Thenable<Array<Uri>>

external fun findFiles(include: String, exclude: RelativePattern? = definedExternally): Thenable<Array<Uri>>

external fun findFiles(include: String, exclude: RelativePattern? = definedExternally, maxResults: Number = definedExternally): Thenable<Array<Uri>>

external fun findFiles(include: RelativePattern, exclude: String? = definedExternally, maxResults: Number = definedExternally, token: CancellationToken = definedExternally): Thenable<Array<Uri>>

external fun findFiles(include: RelativePattern): Thenable<Array<Uri>>

external fun findFiles(include: RelativePattern, exclude: String? = definedExternally): Thenable<Array<Uri>>

external fun findFiles(include: RelativePattern, exclude: String? = definedExternally, maxResults: Number = definedExternally): Thenable<Array<Uri>>

external fun findFiles(include: RelativePattern, exclude: RelativePattern? = definedExternally, maxResults: Number = definedExternally, token: CancellationToken = definedExternally): Thenable<Array<Uri>>

external fun findFiles(include: RelativePattern, exclude: RelativePattern? = definedExternally): Thenable<Array<Uri>>

external fun findFiles(include: RelativePattern, exclude: RelativePattern? = definedExternally, maxResults: Number = definedExternally): Thenable<Array<Uri>>

external fun saveAll(includeUntitled: Boolean = definedExternally): Thenable<Boolean>

external fun applyEdit(edit: WorkspaceEdit): Thenable<Boolean>

external var textDocuments: Array<TextDocument>

external fun openTextDocument(uri: Uri): Thenable<TextDocument>

external fun openTextDocument(fileName: String): Thenable<TextDocument>

external interface `T$46` {
    var language: String?
        get() = definedExternally
        set(value) = definedExternally
    var content: String?
        get() = definedExternally
        set(value) = definedExternally
}

external fun openTextDocument(options: `T$46` = definedExternally): Thenable<TextDocument>

external fun openTextDocument(): Thenable<TextDocument>

external fun registerTextDocumentContentProvider(scheme: String, provider: TextDocumentContentProvider): Disposable

external var onDidOpenTextDocument: Event<TextDocument>

external var onDidCloseTextDocument: Event<TextDocument>

external var onDidChangeTextDocument: Event<TextDocumentChangeEvent>

external var onWillSaveTextDocument: Event<TextDocumentWillSaveEvent>

external var onDidSaveTextDocument: Event<TextDocument>

external var notebookDocuments: Array<NotebookDocument>

external fun openNotebookDocument(uri: Uri): Thenable<NotebookDocument>

external fun openNotebookDocument(notebookType: String, content: NotebookData = definedExternally): Thenable<NotebookDocument>

external fun openNotebookDocument(notebookType: String): Thenable<NotebookDocument>

external fun registerNotebookSerializer(notebookType: String, serializer: NotebookSerializer, options: NotebookDocumentContentOptions = definedExternally): Disposable

external var onDidOpenNotebookDocument: Event<NotebookDocument>

external var onDidCloseNotebookDocument: Event<NotebookDocument>

external var onWillCreateFiles: Event<FileWillCreateEvent>

external var onDidCreateFiles: Event<FileCreateEvent>

external var onWillDeleteFiles: Event<FileWillDeleteEvent>

external var onDidDeleteFiles: Event<FileDeleteEvent>

external var onWillRenameFiles: Event<FileWillRenameEvent>

external var onDidRenameFiles: Event<FileRenameEvent>

external fun getConfiguration(section: String = definedExternally, scope: Uri? = definedExternally): WorkspaceConfiguration

external fun getConfiguration(): WorkspaceConfiguration

external fun getConfiguration(section: String = definedExternally): WorkspaceConfiguration

external fun getConfiguration(section: String = definedExternally, scope: TextDocument? = definedExternally): WorkspaceConfiguration

external fun getConfiguration(section: String = definedExternally, scope: WorkspaceFolder? = definedExternally): WorkspaceConfiguration

external fun getConfiguration(section: String = definedExternally, scope: `T$48`? = definedExternally): WorkspaceConfiguration

external var onDidChangeConfiguration: Event<ConfigurationChangeEvent>

external fun registerTaskProvider(type: String, provider: TaskProvider__0): Disposable

external interface `T$47` {
    var isCaseSensitive: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var isReadonly: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external fun registerFileSystemProvider(scheme: String, provider: FileSystemProvider, options: `T$47` = definedExternally): Disposable

external var isTrusted: Boolean

external var onDidGrantWorkspaceTrust: Event<Unit>