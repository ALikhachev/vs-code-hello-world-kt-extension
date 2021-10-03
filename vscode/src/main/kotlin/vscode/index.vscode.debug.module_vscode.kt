@file:JsModule("vscode")
@file:JsNonModule
@file:JsQualifier("debug")
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package vscode.debug

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
import vscode.DebugSession
import vscode.DebugConsole
import vscode.Breakpoint
import vscode.Event
import vscode.DebugSessionCustomEvent
import vscode.BreakpointsChangeEvent
import vscode.DebugConfigurationProvider
import vscode.DebugConfigurationProviderTriggerKind
import vscode.Disposable
import vscode.DebugAdapterDescriptorFactory
import vscode.DebugAdapterTrackerFactory
import vscode.WorkspaceFolder
import Thenable
import vscode.DebugSessionOptions
import vscode.DebugConfiguration
import vscode.DebugProtocolSource
import vscode.Uri

external var activeDebugSession: DebugSession?

external var activeDebugConsole: DebugConsole

external var breakpoints: Array<Breakpoint>

external var onDidChangeActiveDebugSession: Event<DebugSession?>

external var onDidStartDebugSession: Event<DebugSession>

external var onDidReceiveDebugSessionCustomEvent: Event<DebugSessionCustomEvent>

external var onDidTerminateDebugSession: Event<DebugSession>

external var onDidChangeBreakpoints: Event<BreakpointsChangeEvent>

external fun registerDebugConfigurationProvider(debugType: String, provider: DebugConfigurationProvider, triggerKind: DebugConfigurationProviderTriggerKind = definedExternally): Disposable

external fun registerDebugAdapterDescriptorFactory(debugType: String, factory: DebugAdapterDescriptorFactory): Disposable

external fun registerDebugAdapterTrackerFactory(debugType: String, factory: DebugAdapterTrackerFactory): Disposable

external fun startDebugging(folder: WorkspaceFolder?, nameOrConfiguration: String, parentSessionOrOptions: DebugSession = definedExternally): Thenable<Boolean>

external fun startDebugging(folder: WorkspaceFolder?, nameOrConfiguration: String): Thenable<Boolean>

external fun startDebugging(folder: WorkspaceFolder?, nameOrConfiguration: String, parentSessionOrOptions: DebugSessionOptions = definedExternally): Thenable<Boolean>

external fun startDebugging(folder: WorkspaceFolder?, nameOrConfiguration: DebugConfiguration, parentSessionOrOptions: DebugSession = definedExternally): Thenable<Boolean>

external fun startDebugging(folder: WorkspaceFolder?, nameOrConfiguration: DebugConfiguration): Thenable<Boolean>

external fun startDebugging(folder: WorkspaceFolder?, nameOrConfiguration: DebugConfiguration, parentSessionOrOptions: DebugSessionOptions = definedExternally): Thenable<Boolean>

external fun stopDebugging(session: DebugSession = definedExternally): Thenable<Unit>

external fun addBreakpoints(breakpoints: Array<Breakpoint>)

external fun removeBreakpoints(breakpoints: Array<Breakpoint>)

external fun asDebugSourceUri(source: DebugProtocolSource, session: DebugSession = definedExternally): Uri