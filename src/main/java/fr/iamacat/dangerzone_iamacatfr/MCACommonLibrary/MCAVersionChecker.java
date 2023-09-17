

package fr.iamacat.dangerzone_iamacatfr.MCACommonLibrary;

public class MCAVersionChecker
{
    public static final int VersionID = 2;

    public static void checkForLibraryVersion(final Class modelClass, final int modelVersion) {
        if (modelVersion > 2) {
            System.out.println("MCA WARNING: " + modelClass.getName() + " needs a newer version of the library (" + modelVersion + "). Things could go wrong!");
        }
    }
}
