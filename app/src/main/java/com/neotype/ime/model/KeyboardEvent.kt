package com.neotype.ime.model

/**
 * Sealed class for UI events in the keyboard.
 * Used for communication between different layers of the application.
 */
sealed class KeyboardEvent {
    /**
     * Event when a key is pressed.
     * @property keyCode The code of the pressed key
     * @property text The text of the pressed key
     */
    data class KeyPressed(val keyCode: Int, val text: String) : KeyboardEvent()

    /**
     * Event when a key is long pressed.
     * @property keyCode The code of the long-pressed key
     */
    data class KeyLongPressed(val keyCode: Int) : KeyboardEvent()

    /**
     * Event for swipe gesture on the keyboard.
     * @property direction The direction of the swipe (UP, DOWN, LEFT, RIGHT)
     * @property distance The distance of the swipe in pixels
     */
    data class Swiped(val direction: String, val distance: Float) : KeyboardEvent()

    /**
     * Event to show suggestions.
     * @property suggestions List of suggested words
     */
    data class ShowSuggestions(val suggestions: List<String>) : KeyboardEvent()

    /**
     * Event to clear suggestions.
     */
    object ClearSuggestions : KeyboardEvent()

    /**
     * Event when shift state changes.
     * @property isActive Whether shift is active
     */
    data class ShiftStateChanged(val isActive: Boolean) : KeyboardEvent()

    /**
     * Event when caps lock state changes.
     * @property isActive Whether caps lock is active
     */
    data class CapsLockStateChanged(val isActive: Boolean) : KeyboardEvent()

    /**
     * Event to switch keyboard layout.
     * @property layoutId The ID of the layout to switch to
     */
    data class SwitchLayout(val layoutId: String) : KeyboardEvent()

    /**
     * Event to trigger haptic feedback.
     * @property duration Duration of the feedback in milliseconds
     */
    data class HapticFeedback(val duration: Long = 50) : KeyboardEvent()

    /**
     * Event to play key click sound.
     */
    object PlayKeySound : KeyboardEvent()

    /**
     * Event when settings change.
     * @property settings The updated settings
     */
    data class SettingsChanged(val settings: KeyboardSettings) : KeyboardEvent()
}
