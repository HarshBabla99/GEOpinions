'''
Created on Mar 31, 2018

@author: sabar
'''

import nltk.sentiment.vader

class AggregateSentiment():  
    def __init__(self, sid, values):
        self.sid = sid
        self.values = values

        
    def agg_sentiment(self, i):
        filename = "parsedTweets.out"
        if (i != -1):
            filename = filename + str(i)
        with open(filename, encoding = "utf8") as file_object:
            lines = file_object.readlines()
        
        for line in lines[1:len(lines)]:
            scores = self.sid.polarity_scores(line)
            
            self.values['pos'] += scores['pos']
            self.values['neu'] += scores['neu']
            self.values['neg'] += scores['neg']
            self.values['compound'] += scores['compound']
        
        total = self.values['pos'] + self.values['neu'] + self.values['neg']
        self.values['pos'] = self.values['pos']/total
        self.values['neu'] = self.values['neu']/total
        self.values['neg'] = self.values['neg']/total
        
        self.values['compound'] = self.values['compound']/(len(lines) - 1)
        
        return str(self.values['pos']) + "," + str(self.values['neu']) + "," + str(self.values['neg']);
            
agg_inst = AggregateSentiment(nltk.sentiment.vader.SentimentIntensityAnalyzer(), {'pos' : 0, 'neu' : 0, 'neg' : 0, 'compound' : 0})
print(agg_inst.agg_sentiment(-1))
        
        
 
 
