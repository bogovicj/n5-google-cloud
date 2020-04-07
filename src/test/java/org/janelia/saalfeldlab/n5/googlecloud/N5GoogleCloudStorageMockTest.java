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
package org.janelia.saalfeldlab.n5.googlecloud;

import java.io.IOException;

import org.janelia.saalfeldlab.googlecloud.GoogleCloudClient;
import org.janelia.saalfeldlab.n5.N5Writer;

import com.google.cloud.storage.Storage;
import com.google.cloud.storage.contrib.nio.testing.LocalStorageHelper;

/**
 * Initiates testing of the Google Cloud Storage N5 implementation using mock library.
 *
 * @author Igor Pisarev &lt;pisarevi@janelia.hhmi.org&gt;
 */
public class N5GoogleCloudStorageMockTest extends AbstractN5GoogleCloudStorageTest {

	static private String testBucketName = "n5-test";

	/**
	 * @throws IOException
	 */
	@Override
	protected N5Writer createN5Writer() throws IOException {

		// If the credentials are present in the system, the mock test still prints the warning
		// about using end-user credentials for some reason. Call this method to suppress the warning.
		GoogleCloudClient.getSystemCredentials();

		final Storage storage = LocalStorageHelper.getOptions().getService();
		return new N5GoogleCloudStorageWriter(storage, testBucketName);
	}
}
