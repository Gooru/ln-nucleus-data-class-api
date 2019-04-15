package org.gooru.nucleus.dataclass.api.gateway.routes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RouteConfiguration implements Iterable<RouteConfigurator> {

  private final Iterator<RouteConfigurator> internalIterator;

  public RouteConfiguration() {
    List<RouteConfigurator> configurators = new ArrayList<>(32);
    // First the global handler to enable to body reading etc
    configurators.add(new RouteGlobalConfigurator());
    // Auth configurator should be first.
    configurators.add(new RouteAuthConfigurator());
    configurators.add(new DataClassApiReadConfigurator());
    internalIterator = configurators.iterator();
  }

  @Override
  public Iterator<RouteConfigurator> iterator() {
    return new Iterator<RouteConfigurator>() {

      @Override
      public boolean hasNext() {
        return internalIterator.hasNext();
      }

      @Override
      public RouteConfigurator next() {
        return internalIterator.next();
      }

    };
  }

}
