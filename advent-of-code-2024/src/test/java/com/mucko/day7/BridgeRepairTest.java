package com.mucko.day7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BridgeRepairTest {

    @Test
    void repairBridge() {
        BridgeRepair bridgeRepair = new BridgeRepair();
        assertEquals(11387, bridgeRepair.repairBridge("day7/test.txt"));
    }
}
