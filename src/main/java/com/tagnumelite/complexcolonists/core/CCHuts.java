package com.tagnumelite.complexcolonists.core;

import com.tagnumelite.complexcolonists.addon.complexcolonists.blocks.BlockHutMerchant;
import com.tagnumelite.complexcolonists.addon.complexcolonists.blocks.BlockHutTrader;

import com.minecolonies.api.blocks.AbstractBlockHut;

public class CCHuts {
    public static final BlockHutMerchant MERCHANT = new BlockHutMerchant();
    public static final BlockHutTrader TRADER = new BlockHutTrader();

    public static AbstractBlockHut<?>[] getHuts() {
        return new AbstractBlockHut[]{
                MERCHANT,
                TRADER
        };
    }
}
