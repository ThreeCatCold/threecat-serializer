package com.threecat.serializer.impl;

import com.threecat.serializer.JavaSupportSerializer;

import java.io.*;

public class JavaSupportSerializerImpl implements JavaSupportSerializer
{
	// 传入的对象需实现serializable接口
	@Override
	public <T> byte[] serialize(T object)
	{
		ByteArrayOutputStream baos = null;
		ObjectOutputStream oos = null;

		try
		{
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			return baos.toByteArray();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			// do stream close
		}
		return null;
	}

	@Override
	public <T> T deSerialize(byte[] data, Class<T> clazz)
	{
		ByteArrayInputStream bais = null;
		ObjectInputStream ois = null;
		try
		{
			bais = new ByteArrayInputStream(data);
			ois = new ObjectInputStream(bais);
			return (T)ois.readObject();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			// do stream close
		}
		return null;
	}
}
