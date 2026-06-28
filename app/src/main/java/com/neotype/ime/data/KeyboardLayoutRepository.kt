package com.neotype.ime.data

import com.neotype.ime.model.KeyboardLayoutModel
import com.neotype.ime.model.KeyboardRowModel
import com.neotype.ime.model.KeyModel
import com.neotype.ime.model.SpecialKeyCode

/**
 * Repository for keyboard layouts.
 * Provides different keyboard layouts (QWERTY, numbers, symbols, etc.)
 */
class KeyboardLayoutRepository {

    /**
     * Get the QWERTY keyboard layout.
     */
    fun getQwertyLayout(): KeyboardLayoutModel {
        val row1 = listOf(
            KeyModel(0, "Q"), KeyModel(0, "W"), KeyModel(0, "E"), KeyModel(0, "R"), KeyModel(0, "T"), KeyModel(0, "Y"),
            KeyModel(0, "U"), KeyModel(0, "I"), KeyModel(0, "O"), KeyModel(0, "P")
        )
        val row2 = listOf(
            KeyModel(0, "A"), KeyModel(0, "S"), KeyModel(0, "D"), KeyModel(0, "F"), KeyModel(0, "G"), KeyModel(0, "H"),
            KeyModel(0, "J"), KeyModel(0, "K"), KeyModel(0, "L")
        )
        val row3 = listOf(
            KeyModel(SpecialKeyCode.SHIFT, "↑", isSpecialKey = true, width = 1.5f, isModifier = true),
            KeyModel(0, "Z"), KeyModel(0, "X"), KeyModel(0, "C"), KeyModel(0, "V"), KeyModel(0, "B"),
            KeyModel(0, "N"), KeyModel(0, "M"),
            KeyModel(SpecialKeyCode.BACKSPACE, "⌫", isSpecialKey = true, width = 1.5f)
        )
        val row4 = listOf(
            KeyModel(SpecialKeyCode.CAPS_LOCK, "CAPS", isSpecialKey = true, width = 1.5f, isModifier = true),
            KeyModel(0, "!", width = 1.2f),
            KeyModel(SpecialKeyCode.SPACE, " ", width = 4.0f),
            KeyModel(0, ".", width = 1.2f),
            KeyModel(SpecialKeyCode.ENTER, "↵", isSpecialKey = true, width = 1.5f)
        )

        return KeyboardLayoutModel(
            rows = listOf(
                KeyboardRowModel(row1, "row_1"),
                KeyboardRowModel(row2, "row_2"),
                KeyboardRowModel(row3, "row_3"),
                KeyboardRowModel(row4, "row_4")
            ),
            keyboardId = "qwerty",
            keyboardName = "QWERTY"
        )
    }

    /**
     * Get the number keyboard layout.
     */
    fun getNumberLayout(): KeyboardLayoutModel {
        val row1 = listOf(
            KeyModel(0, "1"), KeyModel(0, "2"), KeyModel(0, "3"),
            KeyModel(0, "4"), KeyModel(0, "5"), KeyModel(0, "6"),
            KeyModel(0, "7"), KeyModel(0, "8"), KeyModel(0, "9"), KeyModel(0, "0")
        )
        val row2 = listOf(
            KeyModel(0, "-"), KeyModel(0, "+"), KeyModel(0, "="), KeyModel(0, "("), KeyModel(0, ")"),
            KeyModel(0, "["), KeyModel(0, "]"), KeyModel(0, "{"), KeyModel(0, "}")
        )
        val row3 = listOf(
            KeyModel(SpecialKeyCode.SHIFT, "SHIFT", isSpecialKey = true, width = 1.5f, isModifier = true),
            KeyModel(0, "*"), KeyModel(0, "/"), KeyModel(0, "<"), KeyModel(0, ">"),
            KeyModel(0, "€"), KeyModel(0, "£"), KeyModel(0, "¥"),
            KeyModel(SpecialKeyCode.BACKSPACE, "⌫", isSpecialKey = true, width = 1.5f)
        )
        val row4 = listOf(
            KeyModel(0, "ABC", isSpecialKey = true, width = 1.5f),
            KeyModel(SpecialKeyCode.SPACE, " ", width = 4.0f),
            KeyModel(0, ".", width = 1.2f),
            KeyModel(SpecialKeyCode.ENTER, "↵", isSpecialKey = true, width = 1.5f)
        )

        return KeyboardLayoutModel(
            rows = listOf(
                KeyboardRowModel(row1, "row_1"),
                KeyboardRowModel(row2, "row_2"),
                KeyboardRowModel(row3, "row_3"),
                KeyboardRowModel(row4, "row_4")
            ),
            keyboardId = "numbers",
            keyboardName = "123"
        )
    }

    /**
     * Get the symbols keyboard layout.
     */
    fun getSymbolsLayout(): KeyboardLayoutModel {
        val row1 = listOf(
            KeyModel(0, "!"), KeyModel(0, "@"), KeyModel(0, "#"), KeyModel(0, "$"), KeyModel(0, "%"),
            KeyModel(0, "&"), KeyModel(0, "*"), KeyModel(0, "("), KeyModel(0, ")"), KeyModel(0, "_")
        )
        val row2 = listOf(
            KeyModel(0, "-"), KeyModel(0, "="), KeyModel(0, "["), KeyModel(0, "]"), KeyModel(0, "{"),
            KeyModel(0, "}"), KeyModel(0, "|"), KeyModel(0, ";"), KeyModel(0, ":"), KeyModel(0, "'")
        )
        val row3 = listOf(
            KeyModel(SpecialKeyCode.SHIFT, "↑", isSpecialKey = true, width = 1.5f, isModifier = true),
            KeyModel(0, ","), KeyModel(0, "<"), KeyModel(0, "."), KeyModel(0, ">"), KeyModel(0, "?"),
            KeyModel(0, "/"), KeyModel(0, "\\"), KeyModel(0, "`"),
            KeyModel(SpecialKeyCode.BACKSPACE, "⌫", isSpecialKey = true, width = 1.5f)
        )
        val row4 = listOf(
            KeyModel(0, "123", isSpecialKey = true, width = 1.5f),
            KeyModel(SpecialKeyCode.SPACE, " ", width = 4.0f),
            KeyModel(0, "."),
            KeyModel(SpecialKeyCode.ENTER, "↵", isSpecialKey = true, width = 1.5f)
        )

        return KeyboardLayoutModel(
            rows = listOf(
                KeyboardRowModel(row1, "row_1"),
                KeyboardRowModel(row2, "row_2"),
                KeyboardRowModel(row3, "row_3"),
                KeyboardRowModel(row4, "row_4")
            ),
            keyboardId = "symbols",
            keyboardName = "!@#"
        )
    }

    /**
     * Get emoji keyboard layout.
     */
    fun getEmojiLayout(): List<String> {
        return listOf(
            "😀", "😁", "😂", "🤣", "😃", "😄",
            "😅", "😆", "😉", "😊", "😇", "🙂",
            "🙃", "😐", "😑", "😶", "🙁", "☹️",
            "😏", "😣", "😒", "🤐", "🤭", "🤫",
            "🤔", "🤤", "😲", "🥺", "😦", "😧",
            "😨", "😰", "😥", "😢", "😭", "😱"
        )
    }

    /**
     * Get suggestions for a given word prefix.
     */
    fun getSuggestions(prefix: String): List<String> {
        val dictionary = mapOf(
            "t" to listOf("the", "that", "this", "there", "then", "them", "they"),
            "a" to listOf("and", "are", "as", "at", "all"),
            "i" to listOf("in", "is", "it", "if"),
            "w" to listOf("was", "were", "will", "with", "would", "what"),
            "h" to listOf("have", "has", "he", "her", "his", "how", "he's"),
            "f" to listOf("for", "from", "first", "find"),
            "o" to listOf("or", "on", "one", "out", "of"),
            "c" to listOf("can", "could", "come"),
            "b" to listOf("be", "been", "by", "but", "before"),
            "y" to listOf("you", "your", "yes", "year")
        )

        val lowerPrefix = prefix.lowercase()
        return dictionary[lowerPrefix]?.take(3) ?: emptyList()
    }

    companion object {
        private var instance: KeyboardLayoutRepository? = null

        /**
         * Get singleton instance of KeyboardLayoutRepository.
         */
        fun getInstance(): KeyboardLayoutRepository {
            return instance ?: synchronized(this) {
                KeyboardLayoutRepository().also { instance = it }
            }
        }
    }
}
