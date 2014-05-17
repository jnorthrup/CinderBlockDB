package kouchdb.web.inf;

import kouchdb.Config;
import one.xio.AsioVisitor.Impl;
import one.xio.HttpMethod;

import java.util.EnumMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * User: jim
 * Date: 6/25/12
 * Time: 1:24 PM
 */
public interface KouchNamespace {

  /**
   * a map of http methods each containing an ordered map of regexes tested in order of
   * map insertion.
   */
  Map<HttpMethod, Map<Pattern, Class<? extends Impl>>> NAMESPACE =
      new EnumMap<>(HttpMethod.class);

  /**
   * defines where 1xio/rxf finds static content root.
   */
  String KOUCH_DEFAULT_FS_ROOT = Config
          .get("CONTENT_ROOT", "./");

  /**
   * creates the orgname used in factories without localized namespaces
   */
  String KOUCH_DEFAULT_ORGNAME = Config.get("ORGNAME", "");

  String getOrgName();

  void setOrgname(String orgname);

  void setEntityName(String entityName);

  String getEntityName();

  String getDefaultEntityName();

  public enum ns {
    orgname {
      @Override
      void setMe(KouchNamespace cl, String ns) {
        cl.setOrgname(ns);

      }
    },
    entityName {
      @Override
      void setMe(KouchNamespace cl, String ns) {
        cl.setEntityName(ns);
      }
    };

    abstract void setMe(KouchNamespace cl, String ns);
  }
}