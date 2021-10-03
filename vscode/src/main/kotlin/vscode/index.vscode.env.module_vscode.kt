@file:JsModule("vscode")
@file:JsNonModule
@file:JsQualifier("env")
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package vscode.env

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
import vscode.Clipboard
import vscode.Event
import vscode.UIKind
import vscode.Uri
import Thenable

external var appName: String

external var appRoot: String

external var appHost: String

external var uriScheme: String

external var language: String

external var clipboard: Clipboard

external var machineId: String

external var sessionId: String

external var isNewAppInstall: Boolean

external var isTelemetryEnabled: Boolean

external var onDidChangeTelemetryEnabled: Event<Boolean>

external var remoteName: String?

external var shell: String

external var uiKind: UIKind

external fun openExternal(target: Uri): Thenable<Boolean>

external fun asExternalUri(target: Uri): Thenable<Uri>