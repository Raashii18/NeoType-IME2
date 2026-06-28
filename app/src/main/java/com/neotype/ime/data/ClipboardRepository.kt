package com.neotype.ime.data

import android.content.Context
import android.content.ClipboardManager

/**
 * Repository for clipboard operations.
 * Handles copying, pasting, and managing clipboard history.
 */
class ClipboardRepository(private val context: Context) {

    private val clipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

    /**
     * Get the current clipboard text.
     */
    fun getClipboardText(): String? {
        return try {
            val clip = clipboardManager.primaryClip
            if (clip != null && clip.itemCount > 0) {
                clip.getItemAt(0).text?.toString()
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }

    /**
     * Copy text to clipboard.
     */
    fun copyToClipboard(text: String, label: String = "NeoType Keyboard") {
        try {
            val clip = android.content.ClipData.newPlainText(label, text)
            clipboardManager.setPrimaryClip(clip)
        } catch (e: Exception) {
            // Handle error silently
        }
    }

    companion object {
        private var instance: ClipboardRepository? = null

        /**
         * Get singleton instance of ClipboardRepository.
         */
        fun getInstance(context: Context): ClipboardRepository {
            return instance ?: synchronized(this) {
                ClipboardRepository(context).also { instance = it }
            }
        }
    }
}
