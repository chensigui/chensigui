测试SPI，调用过程(以ServiceLoader<SpiService>为例)

1、调用iterator.next()，实际上是调用ServiceLoader<SpiService>实现的public S next() 方法
2、接着在next()中return nextService(); 调用private S nextService()
3、在nextService()方法里 
  String cn = nextName;
  nextName = null;
  Class<?> c = null;
  c = Class.forName(cn, false, loader);
  通过反射实例化一个SpiService对象并返回，获取之后就能调用它的方法了
  //缓存提供程序，按实例化顺序
  private LinkedHashMap<String,S> providers = new LinkedHashMap<>();
  S p = service.cast(c.newInstance());
                  providers.put(cn, p);
                  return p;