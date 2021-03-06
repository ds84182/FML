/*
 * Forge Mod Loader
 * Copyright (c) 2012-2013 cpw.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v2.1
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 *
 * Contributors:
 *     cpw - implementation
 */

package cpw.mods.fml.client;

import java.util.List;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;

public class GuiModItemsMissing extends GuiScreen
{
    private List<String> missingItems;
    private String message;

    public GuiModItemsMissing(List<String> items, String message)
    {
        this.missingItems = items;
        this.message = message;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void initGui()
    {
        this.buttonList.add(new GuiButton(1, this.width / 2 - 75, this.height - 38, I18n.format("gui.done")));
    }

    @Override
    protected void actionPerformed(GuiButton p_73875_1_)
    {
        if (p_73875_1_.enabled && p_73875_1_.id == 1)
        {
            FMLClientHandler.instance().showGuiScreen(null);
        }
    }
    @Override
    public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        this.drawDefaultBackground();
        int offset = 85;
        this.drawCenteredString(this.fontRendererObj, "Forge Mod Loader could load this save", this.width / 2, offset, 0xFFFFFF);
        offset += 10;
        this.drawCenteredString(this.fontRendererObj, String.format("There are %d unassigned blocks and items in this save", missingItems.size()), this.width / 2, offset, 0xFFFFFF);
        offset += 10;
        this.drawCenteredString(this.fontRendererObj, "You will not be able to load until they are present again", this.width / 2, offset, 0xFFFFFF);
        super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);
    }
}
