'''
Created on Apr 1, 2018

@author: sabar
'''
import nltk.sentiment.vader
from IndividualSentiment.py import AggregateSentiment

class MultipleSentiments():
    def __init__(self):
        self.sentiment_array = {"","","","","","","","","",""}
        
    def multsentiments(self):
        for i in range(0,10):
            agg_inst = AggregateSentiment(nltk.sentiment.vader.SentimentIntensityAnalyzer(), {'pos' : 0, 'neu' : 0, 'neg' : 0, 'compound' : 0})
            self.sentiment_array = agg_inst.agg_sentiment(i)
        