# Add any ProGuard configurations specific to this
# extension here.

-keep public class com.brandonang.bluegre.Bluegre {
    public *;
 }
-keeppackagenames gnu.kawa**, gnu.expr**

-optimizationpasses 4
-allowaccessmodification
-mergeinterfacesaggressively

-repackageclasses 'com/brandonang/bluegre/repack'
-flattenpackagehierarchy
-dontpreverify
