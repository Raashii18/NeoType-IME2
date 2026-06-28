package com.neotype.ime.data

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * DataStore implementation for persisting keyboard settings.
 * Handles preferences like theme, sound, vibration, etc.
 */
class PreferencesRepository(private val context: Context) {

    private val Context.dataStore by preferencesDataStore(name = "keyboard_preferences")
    private val dataStore = context.dataStore

    // Preference keys
    private val THEME_KEY = stringPreferencesKey("theme")
    private val VIBRATION_ENABLED_KEY = booleanPreferencesKey("vibration_enabled")
    private val SOUND_ENABLED_KEY = booleanPreferencesKey("sound_enabled")
    private val SUGGESTIONS_ENABLED_KEY = booleanPreferencesKey("suggestions_enabled")
    private val KEY_SIZE_KEY = floatPreferencesKey("key_size")
    private val TEXT_SIZE_KEY = floatPreferencesKey("text_size")

    /**
     * Get theme preference as a Flow.
     */
    fun getTheme(): Flow<String> = dataStore.data.map { preferences ->
        preferences[THEME_KEY] ?: "DARK"
    }

    /**
     * Save theme preference.
     */
    suspend fun setTheme(theme: String) {
        dataStore.edit { preferences ->
            preferences[THEME_KEY] = theme
        }
    }

    /**
     * Get vibration enabled preference as a Flow.
     */
    fun isVibrationEnabled(): Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[VIBRATION_ENABLED_KEY] ?: true
    }

    /**
     * Save vibration enabled preference.
     */
    suspend fun setVibrationEnabled(enabled: Boolean) {
        dataStore.edit { preferences ->
            preferences[VIBRATION_ENABLED_KEY] = enabled
        }
    }

    /**
     * Get sound enabled preference as a Flow.
     */
    fun isSoundEnabled(): Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[SOUND_ENABLED_KEY] ?: true
    }

    /**
     * Save sound enabled preference.
     */
    suspend fun setSoundEnabled(enabled: Boolean) {
        dataStore.edit { preferences ->
            preferences[SOUND_ENABLED_KEY] = enabled
        }
    }

    /**
     * Get suggestions enabled preference as a Flow.
     */
    fun areSuggestionsEnabled(): Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[SUGGESTIONS_ENABLED_KEY] ?: true
    }

    /**
     * Save suggestions enabled preference.
     */
    suspend fun setSuggestionsEnabled(enabled: Boolean) {
        dataStore.edit { preferences ->
            preferences[SUGGESTIONS_ENABLED_KEY] = enabled
        }
    }

    /**
     * Get key size preference as a Flow.
     */
    fun getKeySize(): Flow<Float> = dataStore.data.map { preferences ->
        preferences[KEY_SIZE_KEY] ?: 1.0f
    }

    /**
     * Save key size preference.
     */
    suspend fun setKeySize(size: Float) {
        dataStore.edit { preferences ->
            preferences[KEY_SIZE_KEY] = size
        }
    }

    /**
     * Get text size preference as a Flow.
     */
    fun getTextSize(): Flow<Float> = dataStore.data.map { preferences ->
        preferences[TEXT_SIZE_KEY] ?: 1.0f
    }

    /**
     * Save text size preference.
     */
    suspend fun setTextSize(size: Float) {
        dataStore.edit { preferences ->
            preferences[TEXT_SIZE_KEY] = size
        }
    }

    /**
     * Get all settings as a Flow.
     */
    fun getAllSettings(): Flow<Map<String, Any>> = dataStore.data.map { preferences ->
        mapOf(
            "theme" to (preferences[THEME_KEY] ?: "DARK"),
            "vibration_enabled" to (preferences[VIBRATION_ENABLED_KEY] ?: true),
            "sound_enabled" to (preferences[SOUND_ENABLED_KEY] ?: true),
            "suggestions_enabled" to (preferences[SUGGESTIONS_ENABLED_KEY] ?: true),
            "key_size" to (preferences[KEY_SIZE_KEY] ?: 1.0f),
            "text_size" to (preferences[TEXT_SIZE_KEY] ?: 1.0f)
        )
    }

    /**
     * Reset all settings to defaults.
     */
    suspend fun resetToDefaults() {
        dataStore.edit { preferences ->
            preferences.clear()
        }
    }

    companion object {
        private var instance: PreferencesRepository? = null

        /**
         * Get singleton instance of PreferencesRepository.
         */
        fun getInstance(context: Context): PreferencesRepository {
            return instance ?: synchronized(this) {
                PreferencesRepository(context).also { instance = it }
            }
        }
    }
}
