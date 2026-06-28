package com.neotype.ime.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Data class representing a keyboard key with all its properties.
 *
 * @property keyCode The code for the key (used for special keys like backspace, enter)
 * @property displayText The text to display on the key
 * @property isSpecialKey Whether this is a special key (shift, backspace, etc.)
 * @property width The width multiplier for the key (1.0 = normal, 2.0 = double width)
 * @property isModifier Whether this key modifies other keys (shift, ctrl, etc.)
 */
@Parcelize
data class KeyModel(
    val keyCode: Int,
    val displayText: String,
    val isSpecialKey: Boolean = false,
    val width: Float = 1.0f,
    val isModifier: Boolean = false
) : Parcelable

/**
 * Data class representing a row of keys on the keyboard.
 *
 * @property keys List of keys in this row
 * @property rowId Unique identifier for the row
 */
@Parcelize
data class KeyboardRowModel(
    val keys: List<KeyModel>,
    val rowId: String
) : Parcelable

/**
 * Data class representing the entire keyboard layout.
 *
 * @property rows List of keyboard rows
 * @property keyboardId Unique identifier for this keyboard layout
 * @property keyboardName Display name for the keyboard
 */
@Parcelize
data class KeyboardLayoutModel(
    val rows: List<KeyboardRowModel>,
    val keyboardId: String,
    val keyboardName: String
) : Parcelable

/**
 * Data class for keyboard settings and preferences.
 *
 * @property theme The current theme (DARK, LIGHT, NEON)
 * @property vibrationEnabled Whether haptic feedback is enabled
 * @property soundEnabled Whether key click sounds are enabled
 * @property suggestionsEnabled Whether word suggestions are shown
 * @property keySize Size multiplier for keys (0.8 to 1.5)
 * @property textSize Size multiplier for key text (0.8 to 1.5)
 */
data class KeyboardSettings(
    val theme: String = "DARK",
    val vibrationEnabled: Boolean = true,
    val soundEnabled: Boolean = true,
    val suggestionsEnabled: Boolean = true,
    val keySize: Float = 1.0f,
    val textSize: Float = 1.0f
)

/**
 * Data class for word suggestions.
 *
 * @property word The suggested word
 * @property frequency How often this word is used
 * @property confidence Confidence score for the suggestion
 */
data class SuggestionModel(
    val word: String,
    val frequency: Int,
    val confidence: Float
)

/**
 * Data class for clipboard items.
 *
 * @property text The clipboard text content
 * @property timestamp When this item was copied
 * @property id Unique identifier
 */
data class ClipboardItem(
    val text: String,
    val timestamp: Long,
    val id: String
)

/**
 * Enum for keyboard theme options.
 */
enum class Theme {
    DARK,
    LIGHT,
    NEON,
    CLASSIC
}

/**
 * Enum for special key codes.
 */
object SpecialKeyCode {
    const val BACKSPACE = -4
    const val ENTER = -3
    const val SHIFT = -1
    const val SPACE = 32
    const val DELETE = -5
    const val CAPS_LOCK = -6
    const val TAB = 9
}
