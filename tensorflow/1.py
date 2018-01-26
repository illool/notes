import tensorflow as tf
flags = tf.flags #flags是一个文件：flags.py，用于处理命令行参数的解析工作
logging = tf.logging

#调用flags内部的DEFINE_string函数来制定解析规则
flags.DEFINE_string("para_name_1","default_val", "description")
flags.DEFINE_bool("para_name_2","default_val", "description")

#FLAGS是一个对象，保存了解析后的命令行参数
FLAGS = flags.FLAGS

def main(_):
    FLAGS.para_name #调用命令行输入的参数

if __name__ == "__main__": #使用这种方式保证了，如果此文件被其它文件import的时候，不会执行main中的代码

    tf.app.run() #解析命令行参数，调用main函数 main(sys.argv)

# python script.py --para_name_1=name --para_name_2=name2
# 不传的话，会使用默认值
