/*
 * Copyright 2014 Google Inc. All rights reserved.
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

package org.physical_web.physicalweb;

import org.uribeacon.beacon.UriBeacon;
import java.net.URISyntaxException;

/**
 * This class contains a variety of methods
 * that are used to parse ble advertising packets,
 * detect beacon existence from that parsing,
 * afford url expansion codes when creating url byte arrays,
 * and create instances of beacons.
 */
class BeaconHelper {

  private static final byte DEFAULT_TX_POWER = -63;

  public static byte[] createAdvertisingPacket(String url) throws URISyntaxException {
    byte[] advertisingPacket;
    try {
      advertisingPacket = new UriBeacon.Builder()
          .uriString(url)
          .txPowerLevel(DEFAULT_TX_POWER)
          .flags((byte) 0)
          .build().toByteArray();
    } catch (URISyntaxException e) {
      url = UrlShortener.shortenUrl(url);
      advertisingPacket = new UriBeacon.Builder()
          .uriString(url)
          .txPowerLevel(DEFAULT_TX_POWER)
          .flags((byte) 0)
          .build().toByteArray();
    }
    return advertisingPacket;
  }
}


