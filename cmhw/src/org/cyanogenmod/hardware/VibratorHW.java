/*
 * Copyright (C) 2014 The CyanogenMod Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cyanogenmod.hardware;

import org.cyanogenmod.internal.util.FileUtils;

import java.io.File;

public class VibratorHW {
    private static String LEVEL_PATH = "/sys/devices/virtual/timed_output/vibrator/vtg_level";
    private static int MAX_INTENSITY = 31;
    private static int MIN_INTENSITY = 0;

    public static boolean isSupported() {
        return new File(LEVEL_PATH).exists();
    }

    public static int getMaxIntensity()  {
        return MAX_INTENSITY;
    }

    public static int getMinIntensity()  {
        return MIN_INTENSITY;
    }

    public static int getWarningThreshold()  {
        return -1;
    }

    public static int getCurIntensity()  {
        return Integer.parseInt(FileUtils.readOneLine(LEVEL_PATH));
    }

    public static int getDefaultIntensity()  {
        return getMaxIntensity();
    }

    public static boolean setIntensity(int intensity)  {
        return FileUtils.writeLine(LEVEL_PATH, String.valueOf(intensity));
    }
}
