# redis多种java客户端的使用与比较

|         | jedis                                         | lettuce                                                  | redisson                                            |
|---------|-----------------------------------------------|----------------------------------------------------------|-----------------------------------------------------|
| github  | [star(11.5k)](https://github.com/redis/jedis) | [star(5.2k)](https://github.com/lettuce-io/lettuce-core) | [star(22.4k)](https://github.com/redisson/redisson) |
| 支持同步API | 是                           | 是                                                        | 是                                                   |
| 支持异步API | 否                            | 是                                                        | 是                                                   |
| 网络通信    | socket                       | netty                                                    | netty                                               |
| 文档      | 不完备                           | 完善                                                       | 完善                                                  |
| 安全性     | 客户端实例线程不安全，需使用池化技术;   | 线程安全                                                     | 线程安全                                                |
