package com.threecat.serializer;

public interface JavaSupportSerializer
{
	<T> byte[] serialize(T object);

	<T> T deSerialize(byte[] data, Class<T> clazz);
}
