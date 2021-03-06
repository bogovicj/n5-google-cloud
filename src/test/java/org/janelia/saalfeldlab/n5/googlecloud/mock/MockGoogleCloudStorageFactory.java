/**
 * License: GPL
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License 2
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package org.janelia.saalfeldlab.n5.googlecloud.mock;

import com.google.cloud.storage.Storage;
import com.google.cloud.storage.contrib.nio.testing.LocalStorageHelper;
import org.janelia.saalfeldlab.googlecloud.GoogleCloudClient;

import java.io.IOException;

public class MockGoogleCloudStorageFactory {

    private static Storage storage;

    public static Storage getOrCreateStorage() throws IOException {

        if (storage == null) {

            // If the credentials are present in the system, the mock test still prints the warning
            // about using end-user credentials for some reason. Call this method to suppress the warning.
            new GoogleCloudClient() {
                @Override
                public Object create() {
                    return null;
                }
            };

            storage = LocalStorageHelper.getOptions().getService();
        }

        return storage;
    }
}