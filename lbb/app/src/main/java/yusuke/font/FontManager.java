package yusuke.font;

import net.minecraft.util.IntHashMap;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FontManager {
    private static final IntHashMap<FontRenderer> cache = new IntHashMap<>();

    public static FontRenderer get(int size) {
        if (cache.containsItem(size)) return cache.lookup(size);

        FontRenderer font = new FontRenderer(getDiskResource("Roboto-Regular.ttf", size), true, true, false);
        cache.addKey(size, font);
        return font;
    }

    /**
     * Method which gets a font by a resource name
     *
     * @param resource resource name
     * @param size     font size
     * @return font by resource
     */
    public static Font getDiskResource(final String resource, final int size) {
        try {
            return Font.createFont(Font.TRUETYPE_FONT, new File(System.getenv("APPDATA") + "\\yusuke\\resource\\" + resource)).deriveFont((float) size);
        } catch (final FontFormatException | IOException ignored) {
            return null;
        }
    }
}
