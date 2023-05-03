package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ImportFlag;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.NativeContext;
import io.realm.internal.OsList;
import io.realm.internal.OsMap;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.OsSet;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.internal.core.NativeRealmAny;
import io.realm.internal.objectstore.OsObjectBuilder;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_devfiveurjc_agendaly_models_SettingRealmProxy extends com.devfiveurjc.agendaly.models.Setting
    implements RealmObjectProxy, com_devfiveurjc_agendaly_models_SettingRealmProxyInterface {

    static final class SettingColumnInfo extends ColumnInfo {
        long languageColKey;
        long darkModeColKey;

        SettingColumnInfo(OsSchemaInfo schemaInfo) {
            super(2);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Setting");
            this.languageColKey = addColumnDetails("language", "language", objectSchemaInfo);
            this.darkModeColKey = addColumnDetails("darkMode", "darkMode", objectSchemaInfo);
        }

        SettingColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new SettingColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final SettingColumnInfo src = (SettingColumnInfo) rawSrc;
            final SettingColumnInfo dst = (SettingColumnInfo) rawDst;
            dst.languageColKey = src.languageColKey;
            dst.darkModeColKey = src.darkModeColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private SettingColumnInfo columnInfo;
    private ProxyState<com.devfiveurjc.agendaly.models.Setting> proxyState;

    com_devfiveurjc_agendaly_models_SettingRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (SettingColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.devfiveurjc.agendaly.models.Setting>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$language() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.languageColKey);
    }

    @Override
    public void realmSet$language(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.languageColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.languageColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.languageColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.languageColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$darkMode() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.darkModeColKey);
    }

    @Override
    public void realmSet$darkMode(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.darkModeColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.darkModeColKey, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "Setting", false, 2, 0);
        builder.addPersistedProperty(NO_ALIAS, "language", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "darkMode", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static SettingColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new SettingColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Setting";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Setting";
    }

    @SuppressWarnings("cast")
    public static com.devfiveurjc.agendaly.models.Setting createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.devfiveurjc.agendaly.models.Setting obj = realm.createObjectInternal(com.devfiveurjc.agendaly.models.Setting.class, true, excludeFields);

        final com_devfiveurjc_agendaly_models_SettingRealmProxyInterface objProxy = (com_devfiveurjc_agendaly_models_SettingRealmProxyInterface) obj;
        if (json.has("language")) {
            if (json.isNull("language")) {
                objProxy.realmSet$language(null);
            } else {
                objProxy.realmSet$language((String) json.getString("language"));
            }
        }
        if (json.has("darkMode")) {
            if (json.isNull("darkMode")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'darkMode' to null.");
            } else {
                objProxy.realmSet$darkMode((boolean) json.getBoolean("darkMode"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.devfiveurjc.agendaly.models.Setting createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.devfiveurjc.agendaly.models.Setting obj = new com.devfiveurjc.agendaly.models.Setting();
        final com_devfiveurjc_agendaly_models_SettingRealmProxyInterface objProxy = (com_devfiveurjc_agendaly_models_SettingRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("language")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$language((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$language(null);
                }
            } else if (name.equals("darkMode")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$darkMode((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'darkMode' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    static com_devfiveurjc_agendaly_models_SettingRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.devfiveurjc.agendaly.models.Setting.class), false, Collections.<String>emptyList());
        io.realm.com_devfiveurjc_agendaly_models_SettingRealmProxy obj = new io.realm.com_devfiveurjc_agendaly_models_SettingRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.devfiveurjc.agendaly.models.Setting copyOrUpdate(Realm realm, SettingColumnInfo columnInfo, com.devfiveurjc.agendaly.models.Setting object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.devfiveurjc.agendaly.models.Setting) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.devfiveurjc.agendaly.models.Setting copy(Realm realm, SettingColumnInfo columnInfo, com.devfiveurjc.agendaly.models.Setting newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.devfiveurjc.agendaly.models.Setting) cachedRealmObject;
        }

        com_devfiveurjc_agendaly_models_SettingRealmProxyInterface unmanagedSource = (com_devfiveurjc_agendaly_models_SettingRealmProxyInterface) newObject;

        Table table = realm.getTable(com.devfiveurjc.agendaly.models.Setting.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.languageColKey, unmanagedSource.realmGet$language());
        builder.addBoolean(columnInfo.darkModeColKey, unmanagedSource.realmGet$darkMode());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_devfiveurjc_agendaly_models_SettingRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        return managedCopy;
    }

    public static long insert(Realm realm, com.devfiveurjc.agendaly.models.Setting object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.devfiveurjc.agendaly.models.Setting.class);
        long tableNativePtr = table.getNativePtr();
        SettingColumnInfo columnInfo = (SettingColumnInfo) realm.getSchema().getColumnInfo(com.devfiveurjc.agendaly.models.Setting.class);
        long objKey = OsObject.createRow(table);
        cache.put(object, objKey);
        String realmGet$language = ((com_devfiveurjc_agendaly_models_SettingRealmProxyInterface) object).realmGet$language();
        if (realmGet$language != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.languageColKey, objKey, realmGet$language, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.darkModeColKey, objKey, ((com_devfiveurjc_agendaly_models_SettingRealmProxyInterface) object).realmGet$darkMode(), false);
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.devfiveurjc.agendaly.models.Setting.class);
        long tableNativePtr = table.getNativePtr();
        SettingColumnInfo columnInfo = (SettingColumnInfo) realm.getSchema().getColumnInfo(com.devfiveurjc.agendaly.models.Setting.class);
        com.devfiveurjc.agendaly.models.Setting object = null;
        while (objects.hasNext()) {
            object = (com.devfiveurjc.agendaly.models.Setting) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = OsObject.createRow(table);
            cache.put(object, objKey);
            String realmGet$language = ((com_devfiveurjc_agendaly_models_SettingRealmProxyInterface) object).realmGet$language();
            if (realmGet$language != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.languageColKey, objKey, realmGet$language, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.darkModeColKey, objKey, ((com_devfiveurjc_agendaly_models_SettingRealmProxyInterface) object).realmGet$darkMode(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.devfiveurjc.agendaly.models.Setting object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.devfiveurjc.agendaly.models.Setting.class);
        long tableNativePtr = table.getNativePtr();
        SettingColumnInfo columnInfo = (SettingColumnInfo) realm.getSchema().getColumnInfo(com.devfiveurjc.agendaly.models.Setting.class);
        long objKey = OsObject.createRow(table);
        cache.put(object, objKey);
        String realmGet$language = ((com_devfiveurjc_agendaly_models_SettingRealmProxyInterface) object).realmGet$language();
        if (realmGet$language != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.languageColKey, objKey, realmGet$language, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.languageColKey, objKey, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.darkModeColKey, objKey, ((com_devfiveurjc_agendaly_models_SettingRealmProxyInterface) object).realmGet$darkMode(), false);
        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.devfiveurjc.agendaly.models.Setting.class);
        long tableNativePtr = table.getNativePtr();
        SettingColumnInfo columnInfo = (SettingColumnInfo) realm.getSchema().getColumnInfo(com.devfiveurjc.agendaly.models.Setting.class);
        com.devfiveurjc.agendaly.models.Setting object = null;
        while (objects.hasNext()) {
            object = (com.devfiveurjc.agendaly.models.Setting) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = OsObject.createRow(table);
            cache.put(object, objKey);
            String realmGet$language = ((com_devfiveurjc_agendaly_models_SettingRealmProxyInterface) object).realmGet$language();
            if (realmGet$language != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.languageColKey, objKey, realmGet$language, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.languageColKey, objKey, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.darkModeColKey, objKey, ((com_devfiveurjc_agendaly_models_SettingRealmProxyInterface) object).realmGet$darkMode(), false);
        }
    }

    public static com.devfiveurjc.agendaly.models.Setting createDetachedCopy(com.devfiveurjc.agendaly.models.Setting realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.devfiveurjc.agendaly.models.Setting unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.devfiveurjc.agendaly.models.Setting();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.devfiveurjc.agendaly.models.Setting) cachedObject.object;
            }
            unmanagedObject = (com.devfiveurjc.agendaly.models.Setting) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_devfiveurjc_agendaly_models_SettingRealmProxyInterface unmanagedCopy = (com_devfiveurjc_agendaly_models_SettingRealmProxyInterface) unmanagedObject;
        com_devfiveurjc_agendaly_models_SettingRealmProxyInterface realmSource = (com_devfiveurjc_agendaly_models_SettingRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();
        unmanagedCopy.realmSet$language(realmSource.realmGet$language());
        unmanagedCopy.realmSet$darkMode(realmSource.realmGet$darkMode());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Setting = proxy[");
        stringBuilder.append("{language:");
        stringBuilder.append(realmGet$language() != null ? realmGet$language() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{darkMode:");
        stringBuilder.append(realmGet$darkMode());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long objKey = proxyState.getRow$realm().getObjectKey();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (objKey ^ (objKey >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_devfiveurjc_agendaly_models_SettingRealmProxy aSetting = (com_devfiveurjc_agendaly_models_SettingRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aSetting.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aSetting.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aSetting.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
