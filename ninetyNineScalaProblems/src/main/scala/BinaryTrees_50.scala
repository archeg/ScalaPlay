



<!DOCTYPE html>
<html lang="en" class=" is-copy-enabled">
  <head prefix="og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# object: http://ogp.me/ns/object# article: http://ogp.me/ns/article# profile: http://ogp.me/ns/profile#">
    <meta charset='utf-8'>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Language" content="en">
    <meta name="viewport" content="width=1020">
    
    
    <title>ScalaPlay/BinaryTrees_50.scala at master · archeg/ScalaPlay</title>
    <link rel="search" type="application/opensearchdescription+xml" href="/opensearch.xml" title="GitHub">
    <link rel="fluid-icon" href="https://github.com/fluidicon.png" title="GitHub">
    <link rel="apple-touch-icon" sizes="57x57" href="/apple-touch-icon-114.png">
    <link rel="apple-touch-icon" sizes="114x114" href="/apple-touch-icon-114.png">
    <link rel="apple-touch-icon" sizes="72x72" href="/apple-touch-icon-144.png">
    <link rel="apple-touch-icon" sizes="144x144" href="/apple-touch-icon-144.png">
    <meta property="fb:app_id" content="1401488693436528">

      <meta content="@github" name="twitter:site" /><meta content="summary" name="twitter:card" /><meta content="archeg/ScalaPlay" name="twitter:title" /><meta content="ScalaPlay - Repository where I play with scala. Nothing of importance." name="twitter:description" /><meta content="https://avatars0.githubusercontent.com/u/700094?v=3&amp;s=400" name="twitter:image:src" />
      <meta content="GitHub" property="og:site_name" /><meta content="object" property="og:type" /><meta content="https://avatars0.githubusercontent.com/u/700094?v=3&amp;s=400" property="og:image" /><meta content="archeg/ScalaPlay" property="og:title" /><meta content="https://github.com/archeg/ScalaPlay" property="og:url" /><meta content="ScalaPlay - Repository where I play with scala. Nothing of importance." property="og:description" />
      <meta name="browser-stats-url" content="https://api.github.com/_private/browser/stats">
    <meta name="browser-errors-url" content="https://api.github.com/_private/browser/errors">
    <link rel="assets" href="https://assets-cdn.github.com/">
    <link rel="web-socket" href="wss://live.github.com/_sockets/NzAwMDk0OmUwMTRjMWE2ZmQwMzdmM2MwMWRkMzM0NWNkZTQ5ODIyOmViZDFlNTBmMTc3YWI3NmQzMDBmNDQ4MDRjNzhlYjQ2NzJjMmRjZDQwNjg2NmEwMzdiNjRmMGE3ODI1YWE1Mjg=--c53ba321756b0bb79f3adb051c7eea96d2dd8cf9">
    <meta name="pjax-timeout" content="1000">
    <link rel="sudo-modal" href="/sessions/sudo_modal">

    <meta name="msapplication-TileImage" content="/windows-tile.png">
    <meta name="msapplication-TileColor" content="#ffffff">
    <meta name="selected-link" value="repo_source" data-pjax-transient>

    <meta name="google-site-verification" content="KT5gs8h0wvaagLKAVWq8bbeNwnZZK1r1XQysX3xurLU">
    <meta name="google-analytics" content="UA-3769691-2">

<meta content="collector.githubapp.com" name="octolytics-host" /><meta content="github" name="octolytics-app-id" /><meta content="1FDFE7A5:448A:11D517AA:5670A2B1" name="octolytics-dimension-request_id" /><meta content="700094" name="octolytics-actor-id" /><meta content="archeg" name="octolytics-actor-login" /><meta content="36ffb8bf8138a474da1e7d225cbe063bf44ca2befebe1f9bda1e644a749d0c74" name="octolytics-actor-hash" />
<meta content="/&lt;user-name&gt;/&lt;repo-name&gt;/blob/show" data-pjax-transient="true" name="analytics-location" />
<meta content="Rails, view, blob#show" data-pjax-transient="true" name="analytics-event" />


  <meta class="js-ga-set" name="dimension1" content="Logged In">



        <meta name="hostname" content="github.com">
    <meta name="user-login" content="archeg">

        <meta name="expected-hostname" content="github.com">

      <link rel="mask-icon" href="https://assets-cdn.github.com/pinned-octocat.svg" color="#4078c0">
      <link rel="icon" type="image/x-icon" href="https://assets-cdn.github.com/favicon.ico">

    <meta content="c8ba129f3cd8063df505087e410775fa587c3890" name="form-nonce" />

    <link crossorigin="anonymous" href="https://assets-cdn.github.com/assets/github-502ab50993b65c1ac75efa286ffd5304245f6c9bb4171ac014fbcf92f6f688de.css" integrity="sha256-UCq1CZO2XBrHXvoob/1TBCRfbJu0FxrAFPvPkvb2iN4=" media="all" rel="stylesheet" />
    <link crossorigin="anonymous" href="https://assets-cdn.github.com/assets/github2-ebf42d255e330ca3f7549dac879de43cf65f82c36670b5628077508fdf3b1c44.css" integrity="sha256-6/QtJV4zDKP3VJ2sh53kPPZfgsNmcLVigHdQj987HEQ=" media="all" rel="stylesheet" />
    
    


    <meta http-equiv="x-pjax-version" content="cd9958d45e48e8e3157a320e9c346eaa">

      
  <meta name="description" content="ScalaPlay - Repository where I play with scala. Nothing of importance.">
  <meta name="go-import" content="github.com/archeg/ScalaPlay git https://github.com/archeg/ScalaPlay.git">

  <meta content="700094" name="octolytics-dimension-user_id" /><meta content="archeg" name="octolytics-dimension-user_login" /><meta content="48056280" name="octolytics-dimension-repository_id" /><meta content="archeg/ScalaPlay" name="octolytics-dimension-repository_nwo" /><meta content="true" name="octolytics-dimension-repository_public" /><meta content="false" name="octolytics-dimension-repository_is_fork" /><meta content="48056280" name="octolytics-dimension-repository_network_root_id" /><meta content="archeg/ScalaPlay" name="octolytics-dimension-repository_network_root_nwo" />
  <link href="https://github.com/archeg/ScalaPlay/commits/master.atom" rel="alternate" title="Recent Commits to ScalaPlay:master" type="application/atom+xml">

  </head>


  <body class="logged_in   env-production windows vis-public page-blob">
    <a href="#start-of-content" tabindex="1" class="accessibility-aid js-skip-to-content">Skip to content</a>

    
    
    



      <div class="header header-logged-in true" role="banner">
  <div class="container clearfix">

    <a class="header-logo-invertocat" href="https://github.com/" data-hotkey="g d" aria-label="Homepage" data-ga-click="Header, go to dashboard, icon:logo">
  <span class="mega-octicon octicon-mark-github"></span>
</a>


      <div class="site-search repo-scope js-site-search" role="search">
          <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/archeg/ScalaPlay/search" class="js-site-search-form" data-global-search-url="/search" data-repo-search-url="/archeg/ScalaPlay/search" method="get"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /></div>
  <label class="js-chromeless-input-container form-control">
    <div class="scope-badge">This repository</div>
    <input type="text"
      class="js-site-search-focus js-site-search-field is-clearable chromeless-input"
      data-hotkey="s"
      name="q"
      placeholder="Search"
      aria-label="Search this repository"
      data-global-scope-placeholder="Search GitHub"
      data-repo-scope-placeholder="Search"
      tabindex="1"
      autocapitalize="off">
  </label>
</form>
      </div>

      <ul class="header-nav left" role="navigation">
        <li class="header-nav-item">
          <a href="/pulls" class="js-selected-navigation-item header-nav-link" data-ga-click="Header, click, Nav menu - item:pulls context:user" data-hotkey="g p" data-selected-links="/pulls /pulls/assigned /pulls/mentioned /pulls">
            Pull requests
</a>        </li>
        <li class="header-nav-item">
          <a href="/issues" class="js-selected-navigation-item header-nav-link" data-ga-click="Header, click, Nav menu - item:issues context:user" data-hotkey="g i" data-selected-links="/issues /issues/assigned /issues/mentioned /issues">
            Issues
</a>        </li>
          <li class="header-nav-item">
            <a class="header-nav-link" href="https://gist.github.com/" data-ga-click="Header, go to gist, text:gist">Gist</a>
          </li>
      </ul>

    
<ul class="header-nav user-nav right" id="user-links">
  <li class="header-nav-item">
      <span class="js-socket-channel js-updatable-content"
        data-channel="notification-changed:archeg"
        data-url="/notifications/header">
      <a href="/notifications" aria-label="You have unread notifications" class="header-nav-link notification-indicator tooltipped tooltipped-s" data-ga-click="Header, go to notifications, icon:unread" data-hotkey="g n">
          <span class="mail-status unread"></span>
          <span class="octicon octicon-bell"></span>
</a>  </span>

  </li>

  <li class="header-nav-item dropdown js-menu-container">
    <a class="header-nav-link tooltipped tooltipped-s js-menu-target" href="/new"
       aria-label="Create new…"
       data-ga-click="Header, create new, icon:add">
      <span class="octicon octicon-plus left"></span>
      <span class="dropdown-caret"></span>
    </a>

    <div class="dropdown-menu-content js-menu-content">
      <ul class="dropdown-menu dropdown-menu-sw">
        
<a class="dropdown-item" href="/new" data-ga-click="Header, create new repository">
  New repository
</a>


  <a class="dropdown-item" href="/organizations/new" data-ga-click="Header, create new organization">
    New organization
  </a>



  <div class="dropdown-divider"></div>
  <div class="dropdown-header">
    <span title="archeg/ScalaPlay">This repository</span>
  </div>
    <a class="dropdown-item" href="/archeg/ScalaPlay/issues/new" data-ga-click="Header, create new issue">
      New issue
    </a>
    <a class="dropdown-item" href="/archeg/ScalaPlay/settings/collaboration" data-ga-click="Header, create new collaborator">
      New collaborator
    </a>

      </ul>
    </div>
  </li>

  <li class="header-nav-item dropdown js-menu-container">
    <a class="header-nav-link name tooltipped tooltipped-sw js-menu-target" href="/archeg"
       aria-label="View profile and more"
       data-ga-click="Header, show menu, icon:avatar">
      <img alt="@archeg" class="avatar" height="20" src="https://avatars1.githubusercontent.com/u/700094?v=3&amp;s=40" width="20" />
      <span class="dropdown-caret"></span>
    </a>

    <div class="dropdown-menu-content js-menu-content">
      <div class="dropdown-menu  dropdown-menu-sw">
        <div class=" dropdown-header header-nav-current-user css-truncate">
            Signed in as <strong class="css-truncate-target">archeg</strong>

        </div>


        <div class="dropdown-divider"></div>

          <a class="dropdown-item" href="/archeg" data-ga-click="Header, go to profile, text:your profile">
            Your profile
          </a>
        <a class="dropdown-item" href="/stars" data-ga-click="Header, go to starred repos, text:your stars">
          Your stars
        </a>
        <a class="dropdown-item" href="/explore" data-ga-click="Header, go to explore, text:explore">
          Explore
        </a>
          <a class="dropdown-item" href="/integrations" data-ga-click="Header, go to integrations, text:integrations">
            Integrations
          </a>
        <a class="dropdown-item" href="https://help.github.com" data-ga-click="Header, go to help, text:help">
          Help
        </a>

          <div class="dropdown-divider"></div>

          <a class="dropdown-item" href="/settings/profile" data-ga-click="Header, go to settings, icon:settings">
            Settings
          </a>

          <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/logout" class="logout-form" data-form-nonce="c8ba129f3cd8063df505087e410775fa587c3890" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="ZkV/7Yfhq6hXGoUkK0EYCBTBYGDYnfG5Xz26WM+JSAopJ6ZF0qwvW1ovvCU8TtgfCTyUpkfxYQkNKwb7ig6gNw==" /></div>
            <button class="dropdown-item dropdown-signout" data-ga-click="Header, sign out, icon:logout">
              Sign out
            </button>
</form>
      </div>
    </div>
  </li>
</ul>


    
  </div>
</div>

      

      


    <div id="start-of-content" class="accessibility-aid"></div>

      <div id="js-flash-container">
</div>


    <div role="main" class="main-content">
        <div itemscope itemtype="http://schema.org/WebPage">
    <div id="js-repo-pjax-container" class="context-loader-container js-repo-nav-next" data-pjax-container>
      
<div class="pagehead repohead instapaper_ignore readability-menu experiment-repo-nav">
  <div class="container repohead-details-container">

    

<ul class="pagehead-actions">

  <li>
        <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/notifications/subscribe" class="js-social-container" data-autosubmit="true" data-form-nonce="c8ba129f3cd8063df505087e410775fa587c3890" data-remote="true" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="tiTdzSc0L9wMWAKoxYP+ltHsB+6WNuKQ0J9MTMA6PcdbuKg2z3mrF9SnvL2gObafXyXwt2U5hSKS+98CgcJ5bQ==" /></div>      <input id="repository_id" name="repository_id" type="hidden" value="48056280" />

        <div class="select-menu js-menu-container js-select-menu">
          <a href="/archeg/ScalaPlay/subscription"
            class="btn btn-sm btn-with-count select-menu-button js-menu-target" role="button" tabindex="0" aria-haspopup="true"
            data-ga-click="Repository, click Watch settings, action:blob#show">
            <span class="js-select-button">
              <span class="octicon octicon-eye"></span>
              Unwatch
            </span>
          </a>
          <a class="social-count js-social-count" href="/archeg/ScalaPlay/watchers">
            1
          </a>

        <div class="select-menu-modal-holder">
          <div class="select-menu-modal subscription-menu-modal js-menu-content" aria-hidden="true">
            <div class="select-menu-header">
              <span class="octicon octicon-x js-menu-close" role="button" aria-label="Close"></span>
              <span class="select-menu-title">Notifications</span>
            </div>

              <div class="select-menu-list js-navigation-container" role="menu">

                <div class="select-menu-item js-navigation-item " role="menuitem" tabindex="0">
                  <span class="select-menu-item-icon octicon octicon-check"></span>
                  <div class="select-menu-item-text">
                    <input id="do_included" name="do" type="radio" value="included" />
                    <span class="select-menu-item-heading">Not watching</span>
                    <span class="description">Be notified when participating or @mentioned.</span>
                    <span class="js-select-button-text hidden-select-button-text">
                      <span class="octicon octicon-eye"></span>
                      Watch
                    </span>
                  </div>
                </div>

                <div class="select-menu-item js-navigation-item selected" role="menuitem" tabindex="0">
                  <span class="select-menu-item-icon octicon octicon octicon-check"></span>
                  <div class="select-menu-item-text">
                    <input checked="checked" id="do_subscribed" name="do" type="radio" value="subscribed" />
                    <span class="select-menu-item-heading">Watching</span>
                    <span class="description">Be notified of all conversations.</span>
                    <span class="js-select-button-text hidden-select-button-text">
                      <span class="octicon octicon-eye"></span>
                      Unwatch
                    </span>
                  </div>
                </div>

                <div class="select-menu-item js-navigation-item " role="menuitem" tabindex="0">
                  <span class="select-menu-item-icon octicon octicon-check"></span>
                  <div class="select-menu-item-text">
                    <input id="do_ignore" name="do" type="radio" value="ignore" />
                    <span class="select-menu-item-heading">Ignoring</span>
                    <span class="description">Never be notified.</span>
                    <span class="js-select-button-text hidden-select-button-text">
                      <span class="octicon octicon-mute"></span>
                      Stop ignoring
                    </span>
                  </div>
                </div>

              </div>

            </div>
          </div>
        </div>
</form>
  </li>

  <li>
    
  <div class="js-toggler-container js-social-container starring-container ">

    <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/archeg/ScalaPlay/unstar" class="js-toggler-form starred js-unstar-button" data-form-nonce="c8ba129f3cd8063df505087e410775fa587c3890" data-remote="true" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="2jA3o0sqsVslu3QW6jaA5yVdFCBkow8WZOgEywqVLwl464UJnk/6R38qXPRQkfy/BwpcWzSpytOD4d7dWd6FZQ==" /></div>
      <button
        class="btn btn-sm btn-with-count js-toggler-target"
        aria-label="Unstar this repository" title="Unstar archeg/ScalaPlay"
        data-ga-click="Repository, click unstar button, action:blob#show; text:Unstar">
        <span class="octicon octicon-star"></span>
        Unstar
      </button>
        <a class="social-count js-social-count" href="/archeg/ScalaPlay/stargazers">
          0
        </a>
</form>
    <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/archeg/ScalaPlay/star" class="js-toggler-form unstarred js-star-button" data-form-nonce="c8ba129f3cd8063df505087e410775fa587c3890" data-remote="true" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="RXYc0tVD0PVA2x3dcok/SlM1Qat+bJnWnguz2a+PLOu8bpBXTv++oRmqaoItw2fv62p2cix3J75r48M2s5zGGA==" /></div>
      <button
        class="btn btn-sm btn-with-count js-toggler-target"
        aria-label="Star this repository" title="Star archeg/ScalaPlay"
        data-ga-click="Repository, click star button, action:blob#show; text:Star">
        <span class="octicon octicon-star"></span>
        Star
      </button>
        <a class="social-count js-social-count" href="/archeg/ScalaPlay/stargazers">
          0
        </a>
</form>  </div>

  </li>

  <li>
          <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/archeg/ScalaPlay/fork" class="btn-with-count" data-form-nonce="c8ba129f3cd8063df505087e410775fa587c3890" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="z1r3SdZDIvQnE3sh5dakbmcncxMPhEyfk/WiH65mtHFQJ6oRe76a9o/+oNIgLafC5aTNlRg8+SjenJETWheWvg==" /></div>
            <button
                type="submit"
                class="btn btn-sm btn-with-count"
                data-ga-click="Repository, show fork modal, action:blob#show; text:Fork"
                title="Fork your own copy of archeg/ScalaPlay to your account"
                aria-label="Fork your own copy of archeg/ScalaPlay to your account">
              <span class="octicon octicon-repo-forked"></span>
              Fork
            </button>
</form>
    <a href="/archeg/ScalaPlay/network" class="social-count">
      0
    </a>
  </li>
</ul>

    <h1 itemscope itemtype="http://data-vocabulary.org/Breadcrumb" class="entry-title public ">
  <span class="octicon octicon-repo"></span>
  <span class="author"><a href="/archeg" class="url fn" itemprop="url" rel="author"><span itemprop="title">archeg</span></a></span><!--
--><span class="path-divider">/</span><!--
--><strong><a href="/archeg/ScalaPlay" data-pjax="#js-repo-pjax-container">ScalaPlay</a></strong>

  <span class="page-context-loader">
    <img alt="" height="16" src="https://assets-cdn.github.com/images/spinners/octocat-spinner-32.gif" width="16" />
  </span>

</h1>

  </div>
  <div class="container">
    
<nav class="reponav js-repo-nav js-sidenav-container-pjax js-octicon-loaders"
     role="navigation"
     data-pjax="#js-repo-pjax-container">

  <a href="/archeg/ScalaPlay" aria-label="Code" aria-selected="true" class="js-selected-navigation-item selected reponav-item" data-hotkey="g c" data-selected-links="repo_source repo_downloads repo_commits repo_releases repo_tags repo_branches /archeg/ScalaPlay">
    <span class="octicon octicon-code"></span>
    Code
</a>
    <a href="/archeg/ScalaPlay/issues" class="js-selected-navigation-item reponav-item" data-hotkey="g i" data-selected-links="repo_issues repo_labels repo_milestones /archeg/ScalaPlay/issues">
      <span class="octicon octicon-issue-opened"></span>
      Issues
      <span class="counter">0</span>
</a>
  <a href="/archeg/ScalaPlay/pulls" class="js-selected-navigation-item reponav-item" data-hotkey="g p" data-selected-links="repo_pulls /archeg/ScalaPlay/pulls">
    <span class="octicon octicon-git-pull-request"></span>
    Pull requests
    <span class="counter">0</span>
</a>
    <a href="/archeg/ScalaPlay/wiki" class="js-selected-navigation-item reponav-item" data-hotkey="g w" data-selected-links="repo_wiki /archeg/ScalaPlay/wiki">
      <span class="octicon octicon-book"></span>
      Wiki
</a>
  <a href="/archeg/ScalaPlay/pulse" class="js-selected-navigation-item reponav-item" data-selected-links="pulse /archeg/ScalaPlay/pulse">
    <span class="octicon octicon-pulse"></span>
    Pulse
</a>
  <a href="/archeg/ScalaPlay/graphs" class="js-selected-navigation-item reponav-item" data-selected-links="repo_graphs repo_contributors /archeg/ScalaPlay/graphs">
    <span class="octicon octicon-graph"></span>
    Graphs
</a>
    <a href="/archeg/ScalaPlay/settings" class="js-selected-navigation-item reponav-item" data-selected-links="repo_settings repo_branch_settings hooks /archeg/ScalaPlay/settings">
      <span class="octicon octicon-gear"></span>
      Settings
</a>
</nav>

  </div>
</div>

<div class="container new-discussion-timeline experiment-repo-nav">
  <div class="repository-content">

    

<a href="/archeg/ScalaPlay/blob/3e975fc4e13904bcb93b66fe4b239a9a6aeeb7e3/ninetyNineScalaProblems/src/main/scala/BinaryTrees_50.scala" class="hidden js-permalink-shortcut" data-hotkey="y">Permalink</a>

<!-- blob contrib key: blob_contributors:v21:3ee5ab1690a306cbf908c0ac0a8a2650 -->

<div class="file-navigation js-zeroclipboard-container">
  
<div class="select-menu js-menu-container js-select-menu left">
  <button class="btn btn-sm select-menu-button js-menu-target css-truncate" data-hotkey="w"
    title="master"
    type="button" aria-label="Switch branches or tags" tabindex="0" aria-haspopup="true">
    <i>Branch:</i>
    <span class="js-select-button css-truncate-target">master</span>
  </button>

  <div class="select-menu-modal-holder js-menu-content js-navigation-container" data-pjax aria-hidden="true">

    <div class="select-menu-modal">
      <div class="select-menu-header">
        <span class="octicon octicon-x js-menu-close" role="button" aria-label="Close"></span>
        <span class="select-menu-title">Switch branches/tags</span>
      </div>

      <div class="select-menu-filters">
        <div class="select-menu-text-filter">
          <input type="text" aria-label="Find or create a branch…" id="context-commitish-filter-field" class="js-filterable-field js-navigation-enable" placeholder="Find or create a branch…">
        </div>
        <div class="select-menu-tabs">
          <ul>
            <li class="select-menu-tab">
              <a href="#" data-tab-filter="branches" data-filter-placeholder="Find or create a branch…" class="js-select-menu-tab" role="tab">Branches</a>
            </li>
            <li class="select-menu-tab">
              <a href="#" data-tab-filter="tags" data-filter-placeholder="Find a tag…" class="js-select-menu-tab" role="tab">Tags</a>
            </li>
          </ul>
        </div>
      </div>

      <div class="select-menu-list select-menu-tab-bucket js-select-menu-tab-bucket" data-tab-filter="branches" role="menu">

        <div data-filterable-for="context-commitish-filter-field" data-filterable-type="substring">


            <a class="select-menu-item js-navigation-item js-navigation-open selected"
               href="/archeg/ScalaPlay/blob/master/ninetyNineScalaProblems/src/main/scala/BinaryTrees_50.scala"
               data-name="master"
               data-skip-pjax="true"
               rel="nofollow">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <span class="select-menu-item-text css-truncate-target" title="master">
                master
              </span>
            </a>
        </div>

          <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/archeg/ScalaPlay/branches" class="js-create-branch select-menu-item select-menu-new-item-form js-navigation-item js-new-item-form" data-form-nonce="c8ba129f3cd8063df505087e410775fa587c3890" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="2yUXfSj1SnSUeBaQjOOsvZ/tTRTcxso8hz2Y4Y84F8rZmKmiHDt5brc9N0pbrD/+1bgcz2iQl3FYU9XnofLsOA==" /></div>
            <span class="octicon octicon-git-branch select-menu-item-icon"></span>
            <div class="select-menu-item-text">
              <span class="select-menu-item-heading">Create branch: <span class="js-new-item-name"></span></span>
              <span class="description">from ‘master’</span>
            </div>
            <input type="hidden" name="name" id="name" class="js-new-item-value">
            <input type="hidden" name="branch" id="branch" value="master">
            <input type="hidden" name="path" id="path" value="ninetyNineScalaProblems/src/main/scala/BinaryTrees_50.scala">
</form>
      </div>

      <div class="select-menu-list select-menu-tab-bucket js-select-menu-tab-bucket" data-tab-filter="tags">
        <div data-filterable-for="context-commitish-filter-field" data-filterable-type="substring">


        </div>

        <div class="select-menu-no-results">Nothing to show</div>
      </div>

    </div>
  </div>
</div>

  <div class="btn-group right">
    <a href="/archeg/ScalaPlay/find/master"
          class="js-show-file-finder btn btn-sm"
          data-pjax
          data-hotkey="t">
      Find file
    </a>
    <button aria-label="Copy file path to clipboard" class="js-zeroclipboard btn btn-sm zeroclipboard-button tooltipped tooltipped-s" data-copied-hint="Copied!" type="button">Copy path</button>
  </div>
  <div class="breadcrumb js-zeroclipboard-target">
    <span class="repo-root js-repo-root"><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/archeg/ScalaPlay" class="" data-branch="master" data-pjax="true" itemscope="url"><span itemprop="title">ScalaPlay</span></a></span></span><span class="separator">/</span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/archeg/ScalaPlay/tree/master/ninetyNineScalaProblems" class="" data-branch="master" data-pjax="true" itemscope="url"><span itemprop="title">ninetyNineScalaProblems</span></a></span><span class="separator">/</span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/archeg/ScalaPlay/tree/master/ninetyNineScalaProblems/src" class="" data-branch="master" data-pjax="true" itemscope="url"><span itemprop="title">src</span></a></span><span class="separator">/</span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/archeg/ScalaPlay/tree/master/ninetyNineScalaProblems/src/main" class="" data-branch="master" data-pjax="true" itemscope="url"><span itemprop="title">main</span></a></span><span class="separator">/</span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/archeg/ScalaPlay/tree/master/ninetyNineScalaProblems/src/main/scala" class="" data-branch="master" data-pjax="true" itemscope="url"><span itemprop="title">scala</span></a></span><span class="separator">/</span><strong class="final-path">BinaryTrees_50.scala</strong>
  </div>
</div>


  <div class="commit-tease">
      <span class="right">
        <a class="commit-tease-sha" href="/archeg/ScalaPlay/commit/2b74620957db8caaffbd6e4be9560438e28c6a1c" data-pjax>
          2b74620
        </a>
        <time datetime="2015-12-15T16:46:44Z" is="relative-time">Dec 15, 2015</time>
      </span>
      <div>
        <img alt="@archeg" class="avatar" height="20" src="https://avatars1.githubusercontent.com/u/700094?v=3&amp;s=40" width="20" />
        <a href="/archeg" class="user-mention" rel="author">archeg</a>
          <a href="/archeg/ScalaPlay/commit/2b74620957db8caaffbd6e4be9560438e28c6a1c" class="message" data-pjax="true" title="First commit">First commit</a>
      </div>

    <div class="commit-tease-contributors">
      <a class="muted-link contributors-toggle" href="#blob_contributors_box" rel="facebox">
        <strong>1</strong>
         contributor
      </a>
      
    </div>

    <div id="blob_contributors_box" style="display:none">
      <h2 class="facebox-header" data-facebox-id="facebox-header">Users who have contributed to this file</h2>
      <ul class="facebox-user-list" data-facebox-id="facebox-description">
          <li class="facebox-user-list-item">
            <img alt="@archeg" height="24" src="https://avatars3.githubusercontent.com/u/700094?v=3&amp;s=48" width="24" />
            <a href="/archeg">archeg</a>
          </li>
      </ul>
    </div>
  </div>

<div class="file">
  <div class="file-header">
  <div class="file-actions">

    <div class="btn-group">
      <a href="/archeg/ScalaPlay/raw/master/ninetyNineScalaProblems/src/main/scala/BinaryTrees_50.scala" class="btn btn-sm " id="raw-url">Raw</a>
        <a href="/archeg/ScalaPlay/blame/master/ninetyNineScalaProblems/src/main/scala/BinaryTrees_50.scala" class="btn btn-sm js-update-url-with-hash">Blame</a>
      <a href="/archeg/ScalaPlay/commits/master/ninetyNineScalaProblems/src/main/scala/BinaryTrees_50.scala" class="btn btn-sm " rel="nofollow">History</a>
    </div>

        <a class="octicon-btn tooltipped tooltipped-nw"
           href="github-windows://openRepo/https://github.com/archeg/ScalaPlay?branch=master&amp;filepath=ninetyNineScalaProblems%2Fsrc%2Fmain%2Fscala%2FBinaryTrees_50.scala"
           aria-label="Open this file in GitHub Desktop"
           data-ga-click="Repository, open with desktop, type:windows">
            <span class="octicon octicon-device-desktop"></span>
        </a>

        <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/archeg/ScalaPlay/edit/master/ninetyNineScalaProblems/src/main/scala/BinaryTrees_50.scala" class="inline-form js-update-url-with-hash" data-form-nonce="c8ba129f3cd8063df505087e410775fa587c3890" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="t/uYDUkWlkjqc/Oi1QSs9HHKIQ8ANSWCBcOOwkPpIbW0N3jaQC99PxvAd0jM768IFeFG9r2qWLPCBNI+64UEDg==" /></div>
          <button class="octicon-btn tooltipped tooltipped-nw" type="submit"
            aria-label="Edit this file" data-hotkey="e" data-disable-with>
            <span class="octicon octicon-pencil"></span>
          </button>
</form>        <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/archeg/ScalaPlay/delete/master/ninetyNineScalaProblems/src/main/scala/BinaryTrees_50.scala" class="inline-form" data-form-nonce="c8ba129f3cd8063df505087e410775fa587c3890" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="TC+sC1wmtWdwNOabrBDIaIS9jWVhKzL+qW2efFcOL093zjN9YUQSz/1VOmVz6rNKIUaDzyD2QO6xdmNJ0Qp98w==" /></div>
          <button class="octicon-btn octicon-btn-danger tooltipped tooltipped-nw" type="submit"
            aria-label="Delete this file" data-disable-with>
            <span class="octicon octicon-trashcan"></span>
          </button>
</form>  </div>

  <div class="file-info">
      437 lines (358 sloc)
      <span class="file-info-divider"></span>
    16.5 KB
  </div>
</div>

  

  <div class="blob-wrapper data type-scala">
      <table class="highlight tab-size js-file-line-container" data-tab-size="8">
      <tr>
        <td id="L1" class="blob-num js-line-number" data-line-number="1"></td>
        <td id="LC1" class="blob-code blob-code-inner js-file-line"><span class="pl-c">/*</span></td>
      </tr>
      <tr>
        <td id="L2" class="blob-num js-line-number" data-line-number="2"></td>
        <td id="LC2" class="blob-code blob-code-inner js-file-line"><span class="pl-c"> * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)</span></td>
      </tr>
      <tr>
        <td id="L3" class="blob-num js-line-number" data-line-number="3"></td>
        <td id="LC3" class="blob-code blob-code-inner js-file-line"><span class="pl-c"> */</span></td>
      </tr>
      <tr>
        <td id="L4" class="blob-num js-line-number" data-line-number="4"></td>
        <td id="LC4" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L5" class="blob-num js-line-number" data-line-number="5"></td>
        <td id="LC5" class="blob-code blob-code-inner js-file-line"><span class="pl-k">package</span> <span class="pl-en">NinetyNineScalaProblem</span></td>
      </tr>
      <tr>
        <td id="L6" class="blob-num js-line-number" data-line-number="6"></td>
        <td id="LC6" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L7" class="blob-num js-line-number" data-line-number="7"></td>
        <td id="LC7" class="blob-code blob-code-inner js-file-line"><span class="pl-k">import</span> <span class="pl-v">CommonPlay.</span><span class="pl-v">ChapterApp</span></td>
      </tr>
      <tr>
        <td id="L8" class="blob-num js-line-number" data-line-number="8"></td>
        <td id="LC8" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L9" class="blob-num js-line-number" data-line-number="9"></td>
        <td id="LC9" class="blob-code blob-code-inner js-file-line"><span class="pl-k">import</span> <span class="pl-v">scala.annotation.</span><span class="pl-v">tailrec</span></td>
      </tr>
      <tr>
        <td id="L10" class="blob-num js-line-number" data-line-number="10"></td>
        <td id="LC10" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L11" class="blob-num js-line-number" data-line-number="11"></td>
        <td id="LC11" class="blob-code blob-code-inner js-file-line"><span class="pl-c">/**</span></td>
      </tr>
      <tr>
        <td id="L12" class="blob-num js-line-number" data-line-number="12"></td>
        <td id="LC12" class="blob-code blob-code-inner js-file-line"><span class="pl-c">  * Created by archeg on 11/8/2015.</span></td>
      </tr>
      <tr>
        <td id="L13" class="blob-num js-line-number" data-line-number="13"></td>
        <td id="LC13" class="blob-code blob-code-inner js-file-line"><span class="pl-c">  */</span></td>
      </tr>
      <tr>
        <td id="L14" class="blob-num js-line-number" data-line-number="14"></td>
        <td id="LC14" class="blob-code blob-code-inner js-file-line"><span class="pl-k">object</span> <span class="pl-en">BinaryTrees_50</span> <span class="pl-k">extends</span> <span class="pl-e">ChapterApp</span> {</td>
      </tr>
      <tr>
        <td id="L15" class="blob-num js-line-number" data-line-number="15"></td>
        <td id="LC15" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">sealed</span> <span class="pl-k">abstract</span> <span class="pl-k">class</span> <span class="pl-en">Tree</span>[<span class="pl-k">+</span><span class="pl-en">T</span>]</td>
      </tr>
      <tr>
        <td id="L16" class="blob-num js-line-number" data-line-number="16"></td>
        <td id="LC16" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">case</span> <span class="pl-k">class</span> <span class="pl-en">Node</span>[<span class="pl-k">+</span><span class="pl-en">T</span>](<span class="pl-v">value</span>: <span class="pl-en">T</span>, <span class="pl-v">left</span>: <span class="pl-en">Tree</span>[<span class="pl-en">T</span>], <span class="pl-v">right</span>: <span class="pl-en">Tree</span>[<span class="pl-en">T</span>]) <span class="pl-k">extends</span> <span class="pl-e">Tree</span>[<span class="pl-en">T</span>] {</td>
      </tr>
      <tr>
        <td id="L17" class="blob-num js-line-number" data-line-number="17"></td>
        <td id="LC17" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">override</span> <span class="pl-k">def</span> <span class="pl-en">toString</span> <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">&quot;</span>T(<span class="pl-pds">&quot;</span></span> <span class="pl-k">+</span> value.toString <span class="pl-k">+</span> <span class="pl-s"><span class="pl-pds">&quot;</span> <span class="pl-pds">&quot;</span></span> <span class="pl-k">+</span> left.toString <span class="pl-k">+</span> <span class="pl-s"><span class="pl-pds">&quot;</span> <span class="pl-pds">&quot;</span></span> <span class="pl-k">+</span> right.toString <span class="pl-k">+</span> <span class="pl-s"><span class="pl-pds">&quot;</span>)<span class="pl-pds">&quot;</span></span></td>
      </tr>
      <tr>
        <td id="L18" class="blob-num js-line-number" data-line-number="18"></td>
        <td id="LC18" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L19" class="blob-num js-line-number" data-line-number="19"></td>
        <td id="LC19" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">case</span> <span class="pl-k">object</span> <span class="pl-en">End</span> <span class="pl-k">extends</span> <span class="pl-e">Tree</span>[<span class="pl-en">Nothing</span>] {</td>
      </tr>
      <tr>
        <td id="L20" class="blob-num js-line-number" data-line-number="20"></td>
        <td id="LC20" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">override</span> <span class="pl-k">def</span> <span class="pl-en">toString</span> <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">&quot;</span>.<span class="pl-pds">&quot;</span></span></td>
      </tr>
      <tr>
        <td id="L21" class="blob-num js-line-number" data-line-number="21"></td>
        <td id="LC21" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L22" class="blob-num js-line-number" data-line-number="22"></td>
        <td id="LC22" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">object</span> <span class="pl-en">Node</span> {</td>
      </tr>
      <tr>
        <td id="L23" class="blob-num js-line-number" data-line-number="23"></td>
        <td id="LC23" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">apply</span>[<span class="pl-en">T</span>](<span class="pl-v">value</span>: <span class="pl-en">T</span>)<span class="pl-k">:</span> <span class="pl-en">Node</span>[<span class="pl-en">T</span>] <span class="pl-k">=</span> <span class="pl-en">Node</span>(value, <span class="pl-en">End</span>, <span class="pl-en">End</span>)</td>
      </tr>
      <tr>
        <td id="L24" class="blob-num js-line-number" data-line-number="24"></td>
        <td id="LC24" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L25" class="blob-num js-line-number" data-line-number="25"></td>
        <td id="LC25" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L26" class="blob-num js-line-number" data-line-number="26"></td>
        <td id="LC26" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">--------------</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>P55. Construct completely balanced binary trees.<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L27" class="blob-num js-line-number" data-line-number="27"></td>
        <td id="LC27" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p55</span>(<span class="pl-v">nodes</span>: <span class="pl-k">Int</span>, <span class="pl-v">symbol</span>: <span class="pl-k">String</span>) <span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-en">Node</span>[<span class="pl-k">String</span>]] <span class="pl-k">=</span> ((nodes <span class="pl-k">-</span> <span class="pl-c1">1</span>) <span class="pl-k">/</span> <span class="pl-c1">2</span>, (nodes <span class="pl-k">-</span> <span class="pl-c1">1</span>) <span class="pl-k">-</span> (nodes <span class="pl-k">-</span> <span class="pl-c1">1</span>) <span class="pl-k">/</span> <span class="pl-c1">2</span>) <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L28" class="blob-num js-line-number" data-line-number="28"></td>
        <td id="LC28" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> (<span class="pl-c1">1</span>, <span class="pl-c1">1</span>) <span class="pl-k">=&gt;</span> <span class="pl-en">Node</span>(symbol, <span class="pl-en">Node</span>(symbol), <span class="pl-en">Node</span>(symbol)) <span class="pl-k">::</span> <span class="pl-c1">Nil</span></td>
      </tr>
      <tr>
        <td id="L29" class="blob-num js-line-number" data-line-number="29"></td>
        <td id="LC29" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> (<span class="pl-c1">0</span>, <span class="pl-c1">1</span>) <span class="pl-k">=&gt;</span> <span class="pl-en">Node</span>(symbol, <span class="pl-en">Node</span>(symbol), <span class="pl-en">End</span>) <span class="pl-k">::</span> <span class="pl-en">Node</span>(symbol, <span class="pl-en">End</span>, <span class="pl-en">Node</span>(symbol)) <span class="pl-k">::</span>  <span class="pl-c1">Nil</span></td>
      </tr>
      <tr>
        <td id="L30" class="blob-num js-line-number" data-line-number="30"></td>
        <td id="LC30" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> (<span class="pl-c1">0</span>, <span class="pl-c1">0</span>) <span class="pl-k">=&gt;</span> <span class="pl-en">Node</span>(symbol) <span class="pl-k">::</span> <span class="pl-c1">Nil</span></td>
      </tr>
      <tr>
        <td id="L31" class="blob-num js-line-number" data-line-number="31"></td>
        <td id="LC31" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> (x, y) <span class="pl-k">if</span> x <span class="pl-k">!=</span> y <span class="pl-k">=&gt;</span>  (<span class="pl-k">for</span> (a <span class="pl-k">&lt;</span><span class="pl-k">-</span> p55(y, symbol); b <span class="pl-k">&lt;</span><span class="pl-k">-</span> p55(x, symbol)) <span class="pl-k">yield</span> <span class="pl-en">Node</span>(symbol, a, b)) <span class="pl-k">:::</span></td>
      </tr>
      <tr>
        <td id="L32" class="blob-num js-line-number" data-line-number="32"></td>
        <td id="LC32" class="blob-code blob-code-inner js-file-line">                              (<span class="pl-k">for</span> (a <span class="pl-k">&lt;</span><span class="pl-k">-</span> p55(x, symbol); b <span class="pl-k">&lt;</span><span class="pl-k">-</span> p55(y, symbol)) <span class="pl-k">yield</span> <span class="pl-en">Node</span>(symbol, a, b))</td>
      </tr>
      <tr>
        <td id="L33" class="blob-num js-line-number" data-line-number="33"></td>
        <td id="LC33" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> (x, y) <span class="pl-k">=&gt;</span> <span class="pl-k">for</span> (a <span class="pl-k">&lt;</span><span class="pl-k">-</span> p55(y, symbol); b <span class="pl-k">&lt;</span><span class="pl-k">-</span> p55(x, symbol)) <span class="pl-k">yield</span> <span class="pl-en">Node</span>(symbol, a, b)</td>
      </tr>
      <tr>
        <td id="L34" class="blob-num js-line-number" data-line-number="34"></td>
        <td id="LC34" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L35" class="blob-num js-line-number" data-line-number="35"></td>
        <td id="LC35" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L36" class="blob-num js-line-number" data-line-number="36"></td>
        <td id="LC36" class="blob-code blob-code-inner js-file-line">  out(p55(<span class="pl-c1">1</span>, <span class="pl-s"><span class="pl-pds">&quot;</span>x<span class="pl-pds">&quot;</span></span>)) <span class="pl-k">==</span><span class="pl-k">!</span> <span class="pl-s"><span class="pl-pds">&quot;</span>List(T(x . .))<span class="pl-pds">&quot;</span></span></td>
      </tr>
      <tr>
        <td id="L37" class="blob-num js-line-number" data-line-number="37"></td>
        <td id="LC37" class="blob-code blob-code-inner js-file-line">  out(p55(<span class="pl-c1">2</span>, <span class="pl-s"><span class="pl-pds">&quot;</span>x<span class="pl-pds">&quot;</span></span>)) <span class="pl-k">==</span><span class="pl-k">!</span> <span class="pl-s"><span class="pl-pds">&quot;</span>List(T(x T(x . .) .), T(x . T(x . .)))<span class="pl-pds">&quot;</span></span></td>
      </tr>
      <tr>
        <td id="L38" class="blob-num js-line-number" data-line-number="38"></td>
        <td id="LC38" class="blob-code blob-code-inner js-file-line">  out(p55(<span class="pl-c1">3</span>, <span class="pl-s"><span class="pl-pds">&quot;</span>x<span class="pl-pds">&quot;</span></span>)) <span class="pl-k">==</span><span class="pl-k">!</span> <span class="pl-s"><span class="pl-pds">&quot;</span>List(T(x T(x . .) T(x . .)))<span class="pl-pds">&quot;</span></span></td>
      </tr>
      <tr>
        <td id="L39" class="blob-num js-line-number" data-line-number="39"></td>
        <td id="LC39" class="blob-code blob-code-inner js-file-line">  out(p55(<span class="pl-c1">4</span>, <span class="pl-s"><span class="pl-pds">&quot;</span>x<span class="pl-pds">&quot;</span></span>)) <span class="pl-k">==</span><span class="pl-k">!</span> <span class="pl-s"><span class="pl-pds">&quot;</span>List(T(x T(x T(x . .) .) T(x . .)), T(x T(x . T(x . .)) T(x . .)), T(x T(x . .) T(x T(x . .) .)), T(x T(x . .) T(x . T(x . .))))<span class="pl-pds">&quot;</span></span></td>
      </tr>
      <tr>
        <td id="L40" class="blob-num js-line-number" data-line-number="40"></td>
        <td id="LC40" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L41" class="blob-num js-line-number" data-line-number="41"></td>
        <td id="LC41" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p55_2</span>[<span class="pl-en">T</span>](<span class="pl-v">nodes</span>: <span class="pl-k">Int</span>, <span class="pl-v">value</span>: <span class="pl-en">T</span>)<span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-en">Tree</span>[<span class="pl-en">T</span>]] <span class="pl-k">=</span> nodes <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L42" class="blob-num js-line-number" data-line-number="42"></td>
        <td id="LC42" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> n <span class="pl-k">if</span> n <span class="pl-k">&lt;</span> <span class="pl-c1">1</span> <span class="pl-k">=&gt;</span> <span class="pl-en">End</span> <span class="pl-k">::</span> <span class="pl-c1">Nil</span></td>
      </tr>
      <tr>
        <td id="L43" class="blob-num js-line-number" data-line-number="43"></td>
        <td id="LC43" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> n <span class="pl-k">if</span> n <span class="pl-k">%</span> <span class="pl-c1">2</span> <span class="pl-k">==</span> <span class="pl-c1">1</span> <span class="pl-k">=&gt;</span> {</td>
      </tr>
      <tr>
        <td id="L44" class="blob-num js-line-number" data-line-number="44"></td>
        <td id="LC44" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">val</span> <span class="pl-en">subtrees</span> <span class="pl-k">=</span> p55_2(n <span class="pl-k">/</span> <span class="pl-c1">2</span>, value)</td>
      </tr>
      <tr>
        <td id="L45" class="blob-num js-line-number" data-line-number="45"></td>
        <td id="LC45" class="blob-code blob-code-inner js-file-line">      subtrees.flatMap(l <span class="pl-k">=&gt;</span> subtrees.map(r <span class="pl-k">=&gt;</span> <span class="pl-en">Node</span>(value, l, r)))</td>
      </tr>
      <tr>
        <td id="L46" class="blob-num js-line-number" data-line-number="46"></td>
        <td id="LC46" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L47" class="blob-num js-line-number" data-line-number="47"></td>
        <td id="LC47" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> n <span class="pl-k">if</span> n <span class="pl-k">%</span> <span class="pl-c1">2</span> <span class="pl-k">==</span> <span class="pl-c1">0</span> <span class="pl-k">=&gt;</span> {</td>
      </tr>
      <tr>
        <td id="L48" class="blob-num js-line-number" data-line-number="48"></td>
        <td id="LC48" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">val</span> <span class="pl-en">lesserSubtrees</span> <span class="pl-k">=</span> p55_2((n <span class="pl-k">-</span> <span class="pl-c1">1</span>) <span class="pl-k">/</span> <span class="pl-c1">2</span>, value)</td>
      </tr>
      <tr>
        <td id="L49" class="blob-num js-line-number" data-line-number="49"></td>
        <td id="LC49" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">val</span> <span class="pl-en">greaterSubtrees</span> <span class="pl-k">=</span> p55_2((n <span class="pl-k">-</span> <span class="pl-c1">1</span>) <span class="pl-k">/</span> <span class="pl-c1">2</span> <span class="pl-k">+</span> <span class="pl-c1">1</span>, value)</td>
      </tr>
      <tr>
        <td id="L50" class="blob-num js-line-number" data-line-number="50"></td>
        <td id="LC50" class="blob-code blob-code-inner js-file-line">      lesserSubtrees.flatMap(l <span class="pl-k">=&gt;</span> greaterSubtrees.flatMap(g <span class="pl-k">=&gt;</span> <span class="pl-en">List</span>(<span class="pl-en">Node</span>(value, l, g), <span class="pl-en">Node</span>(value, g, l))))</td>
      </tr>
      <tr>
        <td id="L51" class="blob-num js-line-number" data-line-number="51"></td>
        <td id="LC51" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L52" class="blob-num js-line-number" data-line-number="52"></td>
        <td id="LC52" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L53" class="blob-num js-line-number" data-line-number="53"></td>
        <td id="LC53" class="blob-code blob-code-inner js-file-line">  <span class="pl-c">// Same answer, but different order</span></td>
      </tr>
      <tr>
        <td id="L54" class="blob-num js-line-number" data-line-number="54"></td>
        <td id="LC54" class="blob-code blob-code-inner js-file-line">  out(p55_2(<span class="pl-c1">4</span>, <span class="pl-s"><span class="pl-pds">&quot;</span>x<span class="pl-pds">&quot;</span></span>)) <span class="pl-k">==</span><span class="pl-k">!</span> <span class="pl-s"><span class="pl-pds">&quot;</span>List(T(x T(x . .) T(x . T(x . .))), T(x T(x . T(x . .)) T(x . .)), T(x T(x . .) T(x T(x . .) .)), T(x T(x T(x . .) .) T(x . .)))<span class="pl-pds">&quot;</span></span></td>
      </tr>
      <tr>
        <td id="L55" class="blob-num js-line-number" data-line-number="55"></td>
        <td id="LC55" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L56" class="blob-num js-line-number" data-line-number="56"></td>
        <td id="LC56" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">--------------</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>P56. Symmetric binary trees.<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L57" class="blob-num js-line-number" data-line-number="57"></td>
        <td id="LC57" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p56</span>[<span class="pl-en">T</span>](<span class="pl-v">tree</span>: <span class="pl-en">Tree</span>[<span class="pl-en">T</span>])<span class="pl-k">:</span> <span class="pl-k">Boolean</span> <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L58" class="blob-num js-line-number" data-line-number="58"></td>
        <td id="LC58" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">isMirrored</span>(<span class="pl-v">a</span>: <span class="pl-en">Tree</span>[<span class="pl-en">T</span>], <span class="pl-v">b</span>: <span class="pl-en">Tree</span>[<span class="pl-en">T</span>])<span class="pl-k">:</span> <span class="pl-k">Boolean</span> <span class="pl-k">=</span> (a, b) <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L59" class="blob-num js-line-number" data-line-number="59"></td>
        <td id="LC59" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> (<span class="pl-en">End</span>, <span class="pl-en">End</span>) <span class="pl-k">=&gt;</span> <span class="pl-c1">true</span></td>
      </tr>
      <tr>
        <td id="L60" class="blob-num js-line-number" data-line-number="60"></td>
        <td id="LC60" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> (_, <span class="pl-en">End</span>) <span class="pl-k">=&gt;</span> <span class="pl-c1">false</span></td>
      </tr>
      <tr>
        <td id="L61" class="blob-num js-line-number" data-line-number="61"></td>
        <td id="LC61" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> (<span class="pl-en">End</span>, _) <span class="pl-k">=&gt;</span> <span class="pl-c1">false</span></td>
      </tr>
      <tr>
        <td id="L62" class="blob-num js-line-number" data-line-number="62"></td>
        <td id="LC62" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> (<span class="pl-en">Node</span>(_, ax, ay), <span class="pl-en">Node</span>(_, bx, by)) <span class="pl-k">=&gt;</span> isMirrored(ax, bx) <span class="pl-k">&amp;&amp;</span> isMirrored(ay, by)</td>
      </tr>
      <tr>
        <td id="L63" class="blob-num js-line-number" data-line-number="63"></td>
        <td id="LC63" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> _ <span class="pl-k">=&gt;</span> <span class="pl-c1">false</span></td>
      </tr>
      <tr>
        <td id="L64" class="blob-num js-line-number" data-line-number="64"></td>
        <td id="LC64" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L65" class="blob-num js-line-number" data-line-number="65"></td>
        <td id="LC65" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L66" class="blob-num js-line-number" data-line-number="66"></td>
        <td id="LC66" class="blob-code blob-code-inner js-file-line">    tree <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L67" class="blob-num js-line-number" data-line-number="67"></td>
        <td id="LC67" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-en">End</span> <span class="pl-k">=&gt;</span> <span class="pl-c1">true</span></td>
      </tr>
      <tr>
        <td id="L68" class="blob-num js-line-number" data-line-number="68"></td>
        <td id="LC68" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-en">Node</span>(_, a, b) <span class="pl-k">=&gt;</span> isMirrored(a, b)</td>
      </tr>
      <tr>
        <td id="L69" class="blob-num js-line-number" data-line-number="69"></td>
        <td id="LC69" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L70" class="blob-num js-line-number" data-line-number="70"></td>
        <td id="LC70" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L71" class="blob-num js-line-number" data-line-number="71"></td>
        <td id="LC71" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L72" class="blob-num js-line-number" data-line-number="72"></td>
        <td id="LC72" class="blob-code blob-code-inner js-file-line">  out(p56(<span class="pl-en">Node</span>(<span class="pl-c1">&#39;a&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;b&#39;</span>), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;c&#39;</span>)))) <span class="pl-k">===</span> <span class="pl-c1">true</span></td>
      </tr>
      <tr>
        <td id="L73" class="blob-num js-line-number" data-line-number="73"></td>
        <td id="LC73" class="blob-code blob-code-inner js-file-line">  out(p56(<span class="pl-en">Node</span>(<span class="pl-c1">&#39;a&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;b&#39;</span>), <span class="pl-en">End</span>))) <span class="pl-k">===</span> <span class="pl-c1">false</span></td>
      </tr>
      <tr>
        <td id="L74" class="blob-num js-line-number" data-line-number="74"></td>
        <td id="LC74" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L75" class="blob-num js-line-number" data-line-number="75"></td>
        <td id="LC75" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">--------------</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>P57. Binary search trees (dictionaries)<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L76" class="blob-num js-line-number" data-line-number="76"></td>
        <td id="LC76" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L77" class="blob-num js-line-number" data-line-number="77"></td>
        <td id="LC77" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">implicit</span> <span class="pl-k">class</span> <span class="pl-en">BinaryTree</span>[<span class="pl-en">T</span>](<span class="pl-v">tree</span>: <span class="pl-en">Tree</span>[<span class="pl-en">T</span>]) {</td>
      </tr>
      <tr>
        <td id="L78" class="blob-num js-line-number" data-line-number="78"></td>
        <td id="LC78" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">count</span><span class="pl-k">:</span> <span class="pl-k">Int</span> <span class="pl-k">=</span> tree <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L79" class="blob-num js-line-number" data-line-number="79"></td>
        <td id="LC79" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-en">End</span> <span class="pl-k">=&gt;</span> <span class="pl-c1">0</span></td>
      </tr>
      <tr>
        <td id="L80" class="blob-num js-line-number" data-line-number="80"></td>
        <td id="LC80" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-en">Node</span>(_, a, b) <span class="pl-k">=&gt;</span> a.count <span class="pl-k">+</span> b.count <span class="pl-k">+</span> <span class="pl-c1">1</span></td>
      </tr>
      <tr>
        <td id="L81" class="blob-num js-line-number" data-line-number="81"></td>
        <td id="LC81" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L82" class="blob-num js-line-number" data-line-number="82"></td>
        <td id="LC82" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L83" class="blob-num js-line-number" data-line-number="83"></td>
        <td id="LC83" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">addValue</span>[<span class="pl-en">U</span> <span class="pl-k">&gt;</span><span class="pl-k">:</span> <span class="pl-en">T</span>](<span class="pl-v">x</span>: <span class="pl-en">U</span>)(<span class="pl-k">implicit</span> <span class="pl-v">ev</span>: <span class="pl-en">U</span> <span class="pl-k">=&gt;</span> <span class="pl-en">Ordered</span>[<span class="pl-en">U</span>])<span class="pl-k">:</span> <span class="pl-en">Tree</span>[<span class="pl-en">U</span>] <span class="pl-k">=</span> tree <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L84" class="blob-num js-line-number" data-line-number="84"></td>
        <td id="LC84" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-en">End</span> <span class="pl-k">=&gt;</span> <span class="pl-en">Node</span>(x)</td>
      </tr>
      <tr>
        <td id="L85" class="blob-num js-line-number" data-line-number="85"></td>
        <td id="LC85" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-en">Node</span>(v, a, b) <span class="pl-k">if</span> v <span class="pl-k">&gt;=</span> x <span class="pl-k">=&gt;</span> <span class="pl-en">Node</span>(v, a.addValue(x), b)</td>
      </tr>
      <tr>
        <td id="L86" class="blob-num js-line-number" data-line-number="86"></td>
        <td id="LC86" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-en">Node</span>(v, a, b) <span class="pl-k">=&gt;</span> <span class="pl-en">Node</span>(v, a, b.addValue(x))</td>
      </tr>
      <tr>
        <td id="L87" class="blob-num js-line-number" data-line-number="87"></td>
        <td id="LC87" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L88" class="blob-num js-line-number" data-line-number="88"></td>
        <td id="LC88" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L89" class="blob-num js-line-number" data-line-number="89"></td>
        <td id="LC89" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L90" class="blob-num js-line-number" data-line-number="90"></td>
        <td id="LC90" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">implicit</span> <span class="pl-k">class</span> <span class="pl-en">ListExt</span>[<span class="pl-en">T</span>](<span class="pl-v">lst</span>: <span class="pl-en">List</span>[<span class="pl-en">T</span>])(<span class="pl-k">implicit</span> <span class="pl-v">ev</span>: <span class="pl-en">T</span> <span class="pl-k">=&gt;</span> <span class="pl-en">Ordered</span>[<span class="pl-en">T</span>]) {</td>
      </tr>
      <tr>
        <td id="L91" class="blob-num js-line-number" data-line-number="91"></td>
        <td id="LC91" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">toBinaryTree</span> <span class="pl-k">:</span> <span class="pl-en">Tree</span>[<span class="pl-en">T</span>] <span class="pl-k">=</span> lst <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L92" class="blob-num js-line-number" data-line-number="92"></td>
        <td id="LC92" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-c1">Nil</span> <span class="pl-k">=&gt;</span> <span class="pl-en">End</span></td>
      </tr>
      <tr>
        <td id="L93" class="blob-num js-line-number" data-line-number="93"></td>
        <td id="LC93" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> head <span class="pl-k">::</span> tail <span class="pl-k">=&gt;</span> tail.toBinaryTree.addValue(head)</td>
      </tr>
      <tr>
        <td id="L94" class="blob-num js-line-number" data-line-number="94"></td>
        <td id="LC94" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L95" class="blob-num js-line-number" data-line-number="95"></td>
        <td id="LC95" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L96" class="blob-num js-line-number" data-line-number="96"></td>
        <td id="LC96" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L97" class="blob-num js-line-number" data-line-number="97"></td>
        <td id="LC97" class="blob-code blob-code-inner js-file-line">  out(<span class="pl-en">End</span>.addValue(<span class="pl-c1">2</span>)) <span class="pl-k">===</span> <span class="pl-en">Node</span>(<span class="pl-c1">2</span>)</td>
      </tr>
      <tr>
        <td id="L98" class="blob-num js-line-number" data-line-number="98"></td>
        <td id="LC98" class="blob-code blob-code-inner js-file-line">  out(<span class="pl-en">End</span>.addValue(<span class="pl-c1">2</span>).addValue(<span class="pl-c1">3</span>)) <span class="pl-k">===</span> <span class="pl-en">Node</span>(<span class="pl-c1">2</span>, <span class="pl-en">End</span>, <span class="pl-en">Node</span>(<span class="pl-c1">3</span>))</td>
      </tr>
      <tr>
        <td id="L99" class="blob-num js-line-number" data-line-number="99"></td>
        <td id="LC99" class="blob-code blob-code-inner js-file-line">  out(<span class="pl-en">End</span>.addValue(<span class="pl-c1">2</span>).addValue(<span class="pl-c1">3</span>).addValue(<span class="pl-c1">0</span>)) <span class="pl-k">===</span> <span class="pl-en">Node</span>(<span class="pl-c1">2</span>, <span class="pl-en">Node</span>(<span class="pl-c1">0</span>), <span class="pl-en">Node</span>(<span class="pl-c1">3</span>))</td>
      </tr>
      <tr>
        <td id="L100" class="blob-num js-line-number" data-line-number="100"></td>
        <td id="LC100" class="blob-code blob-code-inner js-file-line">  out(p56(<span class="pl-en">End</span>.addValue(<span class="pl-c1">2</span>).addValue(<span class="pl-c1">3</span>).addValue(<span class="pl-c1">0</span>))) <span class="pl-k">===</span> <span class="pl-c1">true</span></td>
      </tr>
      <tr>
        <td id="L101" class="blob-num js-line-number" data-line-number="101"></td>
        <td id="LC101" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L102" class="blob-num js-line-number" data-line-number="102"></td>
        <td id="LC102" class="blob-code blob-code-inner js-file-line">  out(<span class="pl-en">List</span>(<span class="pl-c1">5</span>, <span class="pl-c1">3</span>, <span class="pl-c1">18</span>, <span class="pl-c1">1</span>, <span class="pl-c1">4</span>, <span class="pl-c1">12</span>, <span class="pl-c1">21</span>).toBinaryTree)</td>
      </tr>
      <tr>
        <td id="L103" class="blob-num js-line-number" data-line-number="103"></td>
        <td id="LC103" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L104" class="blob-num js-line-number" data-line-number="104"></td>
        <td id="LC104" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">--------------</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>P58. Generate-and-test paradigm.<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L105" class="blob-num js-line-number" data-line-number="105"></td>
        <td id="LC105" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L106" class="blob-num js-line-number" data-line-number="106"></td>
        <td id="LC106" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p58</span>[<span class="pl-en">T</span>](<span class="pl-v">number</span>: <span class="pl-k">Int</span>, <span class="pl-v">v</span>: <span class="pl-k">String</span>)<span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-en">Tree</span>[<span class="pl-k">String</span>]] <span class="pl-k">=</span> p55(number, v) filter {p56(_)}</td>
      </tr>
      <tr>
        <td id="L107" class="blob-num js-line-number" data-line-number="107"></td>
        <td id="LC107" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L108" class="blob-num js-line-number" data-line-number="108"></td>
        <td id="LC108" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">--------------</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>P59. Construct height-balanced binary trees.<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L109" class="blob-num js-line-number" data-line-number="109"></td>
        <td id="LC109" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L110" class="blob-num js-line-number" data-line-number="110"></td>
        <td id="LC110" class="blob-code blob-code-inner js-file-line">  <span class="pl-c">// ????????????????</span></td>
      </tr>
      <tr>
        <td id="L111" class="blob-num js-line-number" data-line-number="111"></td>
        <td id="LC111" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p59</span>[<span class="pl-en">T</span>](<span class="pl-v">height</span>: <span class="pl-k">Int</span>, <span class="pl-v">value</span>: <span class="pl-en">T</span>)<span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-en">Tree</span>[<span class="pl-en">T</span>]] <span class="pl-k">=</span> height <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L112" class="blob-num js-line-number" data-line-number="112"></td>
        <td id="LC112" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> n <span class="pl-k">if</span> n <span class="pl-k">&lt;</span> <span class="pl-c1">1</span> <span class="pl-k">=&gt;</span> <span class="pl-en">End</span> <span class="pl-k">::</span> <span class="pl-c1">Nil</span></td>
      </tr>
      <tr>
        <td id="L113" class="blob-num js-line-number" data-line-number="113"></td>
        <td id="LC113" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> <span class="pl-c1">1</span> <span class="pl-k">=&gt;</span> <span class="pl-en">Node</span>(value) <span class="pl-k">::</span> <span class="pl-c1">Nil</span></td>
      </tr>
      <tr>
        <td id="L114" class="blob-num js-line-number" data-line-number="114"></td>
        <td id="LC114" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> _ <span class="pl-k">=&gt;</span> {</td>
      </tr>
      <tr>
        <td id="L115" class="blob-num js-line-number" data-line-number="115"></td>
        <td id="LC115" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">val</span> <span class="pl-en">fullHeight</span> <span class="pl-k">=</span> p59(height <span class="pl-k">-</span> <span class="pl-c1">1</span>, value)</td>
      </tr>
      <tr>
        <td id="L116" class="blob-num js-line-number" data-line-number="116"></td>
        <td id="LC116" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">val</span> <span class="pl-en">short</span> <span class="pl-k">=</span> p59(height <span class="pl-k">-</span> <span class="pl-c1">2</span>, value)</td>
      </tr>
      <tr>
        <td id="L117" class="blob-num js-line-number" data-line-number="117"></td>
        <td id="LC117" class="blob-code blob-code-inner js-file-line">      (fullHeight flatMap { l <span class="pl-k">=&gt;</span> fullHeight.map(r <span class="pl-k">=&gt;</span> <span class="pl-en">Node</span>(value, l, r)) }) <span class="pl-k">:::</span></td>
      </tr>
      <tr>
        <td id="L118" class="blob-num js-line-number" data-line-number="118"></td>
        <td id="LC118" class="blob-code blob-code-inner js-file-line">        (fullHeight flatMap {f <span class="pl-k">=&gt;</span> short.flatMap(s <span class="pl-k">=&gt;</span> <span class="pl-en">Node</span>(value, f, s) <span class="pl-k">::</span> <span class="pl-en">Node</span>(value, s, f) <span class="pl-k">::</span> <span class="pl-c1">Nil</span>)})</td>
      </tr>
      <tr>
        <td id="L119" class="blob-num js-line-number" data-line-number="119"></td>
        <td id="LC119" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L120" class="blob-num js-line-number" data-line-number="120"></td>
        <td id="LC120" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L121" class="blob-num js-line-number" data-line-number="121"></td>
        <td id="LC121" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L122" class="blob-num js-line-number" data-line-number="122"></td>
        <td id="LC122" class="blob-code blob-code-inner js-file-line">  out(p59(<span class="pl-c1">3</span>, <span class="pl-s"><span class="pl-pds">&quot;</span>s<span class="pl-pds">&quot;</span></span>))</td>
      </tr>
      <tr>
        <td id="L123" class="blob-num js-line-number" data-line-number="123"></td>
        <td id="LC123" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L124" class="blob-num js-line-number" data-line-number="124"></td>
        <td id="LC124" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">--------------</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>P61. Count the leaves of a binary tree.<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L125" class="blob-num js-line-number" data-line-number="125"></td>
        <td id="LC125" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p61</span>[<span class="pl-en">T</span>](<span class="pl-v">tree</span>: <span class="pl-en">Tree</span>[<span class="pl-en">T</span>])<span class="pl-k">:</span> <span class="pl-k">Int</span> <span class="pl-k">=</span> tree <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L126" class="blob-num js-line-number" data-line-number="126"></td>
        <td id="LC126" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> <span class="pl-en">End</span> <span class="pl-k">=&gt;</span> <span class="pl-c1">0</span></td>
      </tr>
      <tr>
        <td id="L127" class="blob-num js-line-number" data-line-number="127"></td>
        <td id="LC127" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> <span class="pl-en">Node</span>(_, <span class="pl-en">End</span>, <span class="pl-en">End</span>) <span class="pl-k">=&gt;</span> <span class="pl-c1">1</span></td>
      </tr>
      <tr>
        <td id="L128" class="blob-num js-line-number" data-line-number="128"></td>
        <td id="LC128" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> <span class="pl-en">Node</span>(_, x, y) <span class="pl-k">=&gt;</span> p61(x) <span class="pl-k">+</span> p61(y)</td>
      </tr>
      <tr>
        <td id="L129" class="blob-num js-line-number" data-line-number="129"></td>
        <td id="LC129" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L130" class="blob-num js-line-number" data-line-number="130"></td>
        <td id="LC130" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L131" class="blob-num js-line-number" data-line-number="131"></td>
        <td id="LC131" class="blob-code blob-code-inner js-file-line">  out(p61(<span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>), <span class="pl-en">End</span>))) <span class="pl-k">===</span> <span class="pl-c1">1</span></td>
      </tr>
      <tr>
        <td id="L132" class="blob-num js-line-number" data-line-number="132"></td>
        <td id="LC132" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L133" class="blob-num js-line-number" data-line-number="133"></td>
        <td id="LC133" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p61A</span>[<span class="pl-en">T</span>](<span class="pl-v">tree</span>: <span class="pl-en">Tree</span>[<span class="pl-en">T</span>])<span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-en">T</span>] <span class="pl-k">=</span> tree <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L134" class="blob-num js-line-number" data-line-number="134"></td>
        <td id="LC134" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> <span class="pl-en">End</span> <span class="pl-k">=&gt;</span> <span class="pl-c1">Nil</span></td>
      </tr>
      <tr>
        <td id="L135" class="blob-num js-line-number" data-line-number="135"></td>
        <td id="LC135" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> <span class="pl-en">Node</span>(v, <span class="pl-en">End</span>, <span class="pl-en">End</span>) <span class="pl-k">=&gt;</span> v <span class="pl-k">::</span> <span class="pl-c1">Nil</span></td>
      </tr>
      <tr>
        <td id="L136" class="blob-num js-line-number" data-line-number="136"></td>
        <td id="LC136" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> <span class="pl-en">Node</span>(_, x, y) <span class="pl-k">=&gt;</span> p61A(x) <span class="pl-k">:::</span> p61A(y)</td>
      </tr>
      <tr>
        <td id="L137" class="blob-num js-line-number" data-line-number="137"></td>
        <td id="LC137" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L138" class="blob-num js-line-number" data-line-number="138"></td>
        <td id="LC138" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L139" class="blob-num js-line-number" data-line-number="139"></td>
        <td id="LC139" class="blob-code blob-code-inner js-file-line">  out(p61A( <span class="pl-en">Node</span>(<span class="pl-c1">&#39;a&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;b&#39;</span>), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;c&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;d&#39;</span>), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;e&#39;</span>))))) <span class="pl-k">===</span> <span class="pl-en">List</span>(<span class="pl-c1">&#39;b&#39;</span>, <span class="pl-c1">&#39;d&#39;</span>, <span class="pl-c1">&#39;e&#39;</span>)</td>
      </tr>
      <tr>
        <td id="L140" class="blob-num js-line-number" data-line-number="140"></td>
        <td id="LC140" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L141" class="blob-num js-line-number" data-line-number="141"></td>
        <td id="LC141" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">--------------</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>P62. Collect the internal nodes of a binary tree in a list.<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L142" class="blob-num js-line-number" data-line-number="142"></td>
        <td id="LC142" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p62</span>[<span class="pl-en">T</span>](<span class="pl-v">tree</span>: <span class="pl-en">Tree</span>[<span class="pl-en">T</span>])<span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-en">T</span>] <span class="pl-k">=</span> tree <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L143" class="blob-num js-line-number" data-line-number="143"></td>
        <td id="LC143" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> <span class="pl-en">End</span> <span class="pl-k">=&gt;</span> <span class="pl-c1">Nil</span></td>
      </tr>
      <tr>
        <td id="L144" class="blob-num js-line-number" data-line-number="144"></td>
        <td id="LC144" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> <span class="pl-en">Node</span>(_, <span class="pl-en">End</span>, <span class="pl-en">End</span>) <span class="pl-k">=&gt;</span> <span class="pl-c1">Nil</span></td>
      </tr>
      <tr>
        <td id="L145" class="blob-num js-line-number" data-line-number="145"></td>
        <td id="LC145" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> <span class="pl-en">Node</span>(v, x, y) <span class="pl-k">=&gt;</span> v <span class="pl-k">::</span> p62(x) <span class="pl-k">:::</span> p62(y)</td>
      </tr>
      <tr>
        <td id="L146" class="blob-num js-line-number" data-line-number="146"></td>
        <td id="LC146" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L147" class="blob-num js-line-number" data-line-number="147"></td>
        <td id="LC147" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L148" class="blob-num js-line-number" data-line-number="148"></td>
        <td id="LC148" class="blob-code blob-code-inner js-file-line">  out(p62(<span class="pl-en">Node</span>(<span class="pl-c1">&#39;a&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;b&#39;</span>), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;c&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;d&#39;</span>), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;e&#39;</span>))))) <span class="pl-k">===</span> <span class="pl-en">List</span>(<span class="pl-c1">&#39;a&#39;</span>, <span class="pl-c1">&#39;c&#39;</span>)</td>
      </tr>
      <tr>
        <td id="L149" class="blob-num js-line-number" data-line-number="149"></td>
        <td id="LC149" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L150" class="blob-num js-line-number" data-line-number="150"></td>
        <td id="LC150" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p62B</span>[<span class="pl-en">T</span>](<span class="pl-v">tree</span>: <span class="pl-en">Tree</span>[<span class="pl-en">T</span>], <span class="pl-v">level</span>: <span class="pl-k">Int</span>) <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L151" class="blob-num js-line-number" data-line-number="151"></td>
        <td id="LC151" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">inner</span>(<span class="pl-v">tree</span>: <span class="pl-en">Tree</span>[<span class="pl-en">T</span>], <span class="pl-v">curLevel</span>: <span class="pl-k">Int</span>)<span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-en">T</span>] <span class="pl-k">=</span> (curLevel, tree) <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L152" class="blob-num js-line-number" data-line-number="152"></td>
        <td id="LC152" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> (`level`, <span class="pl-en">Node</span>(v, _, _)) <span class="pl-k">=&gt;</span> v <span class="pl-k">::</span> <span class="pl-c1">Nil</span></td>
      </tr>
      <tr>
        <td id="L153" class="blob-num js-line-number" data-line-number="153"></td>
        <td id="LC153" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> (_, <span class="pl-en">End</span>) <span class="pl-k">=&gt;</span> <span class="pl-c1">Nil</span></td>
      </tr>
      <tr>
        <td id="L154" class="blob-num js-line-number" data-line-number="154"></td>
        <td id="LC154" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> (_, <span class="pl-en">Node</span>(_, r, l)) <span class="pl-k">=&gt;</span> inner(r, curLevel <span class="pl-k">+</span> <span class="pl-c1">1</span>) <span class="pl-k">:::</span> inner(l, curLevel <span class="pl-k">+</span> <span class="pl-c1">1</span>)</td>
      </tr>
      <tr>
        <td id="L155" class="blob-num js-line-number" data-line-number="155"></td>
        <td id="LC155" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L156" class="blob-num js-line-number" data-line-number="156"></td>
        <td id="LC156" class="blob-code blob-code-inner js-file-line">    inner(tree, <span class="pl-c1">1</span>)</td>
      </tr>
      <tr>
        <td id="L157" class="blob-num js-line-number" data-line-number="157"></td>
        <td id="LC157" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L158" class="blob-num js-line-number" data-line-number="158"></td>
        <td id="LC158" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L159" class="blob-num js-line-number" data-line-number="159"></td>
        <td id="LC159" class="blob-code blob-code-inner js-file-line">  out(p62B(<span class="pl-en">Node</span>(<span class="pl-c1">&#39;a&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;b&#39;</span>), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;c&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;d&#39;</span>), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;e&#39;</span>))), <span class="pl-c1">2</span>)) <span class="pl-k">===</span> <span class="pl-en">List</span>(<span class="pl-c1">&#39;b&#39;</span>, <span class="pl-c1">&#39;c&#39;</span>)</td>
      </tr>
      <tr>
        <td id="L160" class="blob-num js-line-number" data-line-number="160"></td>
        <td id="LC160" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L161" class="blob-num js-line-number" data-line-number="161"></td>
        <td id="LC161" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L162" class="blob-num js-line-number" data-line-number="162"></td>
        <td id="LC162" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">--------------</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>P63. Construct a complete binary tree.<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L163" class="blob-num js-line-number" data-line-number="163"></td>
        <td id="LC163" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p63</span>[<span class="pl-en">T</span>](<span class="pl-v">number</span>: <span class="pl-k">Int</span>, <span class="pl-v">value</span>: <span class="pl-en">T</span>)<span class="pl-k">:</span> <span class="pl-en">Tree</span>[<span class="pl-en">T</span>] <span class="pl-k">=</span> number <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L164" class="blob-num js-line-number" data-line-number="164"></td>
        <td id="LC164" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> <span class="pl-c1">0</span> <span class="pl-k">=&gt;</span> <span class="pl-en">End</span></td>
      </tr>
      <tr>
        <td id="L165" class="blob-num js-line-number" data-line-number="165"></td>
        <td id="LC165" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> <span class="pl-c1">1</span> <span class="pl-k">=&gt;</span> <span class="pl-en">Node</span>(value)</td>
      </tr>
      <tr>
        <td id="L166" class="blob-num js-line-number" data-line-number="166"></td>
        <td id="LC166" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> x <span class="pl-k">=&gt;</span></td>
      </tr>
      <tr>
        <td id="L167" class="blob-num js-line-number" data-line-number="167"></td>
        <td id="LC167" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">val</span> <span class="pl-en">innerNodes</span> <span class="pl-k">=</span> math.pow(<span class="pl-c1">2</span>, math.floor(math.log(x <span class="pl-k">+</span> <span class="pl-c1">1</span>) <span class="pl-k">/</span> math.log(<span class="pl-c1">2</span>))).toInt <span class="pl-k">-</span> <span class="pl-c1">1</span> <span class="pl-c">// The biggest power of 2 &lt; number and -1. This is the number of inner nodes for a tree</span></td>
      </tr>
      <tr>
        <td id="L168" class="blob-num js-line-number" data-line-number="168"></td>
        <td id="LC168" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">val</span> <span class="pl-en">leftLeaves</span> <span class="pl-k">=</span> math.min(x <span class="pl-k">-</span> innerNodes, (innerNodes <span class="pl-k">+</span> <span class="pl-c1">1</span>) <span class="pl-k">/</span> <span class="pl-c1">2</span>)                     <span class="pl-c">// Number of nodes in the leaves in the left subtree</span></td>
      </tr>
      <tr>
        <td id="L169" class="blob-num js-line-number" data-line-number="169"></td>
        <td id="LC169" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">val</span> <span class="pl-en">rightLeaves</span> <span class="pl-k">=</span> math.max(x <span class="pl-k">-</span> innerNodes <span class="pl-k">-</span> leftLeaves, <span class="pl-c1">0</span>)</td>
      </tr>
      <tr>
        <td id="L170" class="blob-num js-line-number" data-line-number="170"></td>
        <td id="LC170" class="blob-code blob-code-inner js-file-line">      <span class="pl-en">Node</span>(value, p63(leftLeaves <span class="pl-k">+</span> (innerNodes <span class="pl-k">-</span> <span class="pl-c1">1</span>) <span class="pl-k">/</span> <span class="pl-c1">2</span>, value), p63(rightLeaves <span class="pl-k">+</span> (innerNodes <span class="pl-k">-</span> <span class="pl-c1">1</span>) <span class="pl-k">/</span> <span class="pl-c1">2</span>, value))</td>
      </tr>
      <tr>
        <td id="L171" class="blob-num js-line-number" data-line-number="171"></td>
        <td id="LC171" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L172" class="blob-num js-line-number" data-line-number="172"></td>
        <td id="LC172" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L173" class="blob-num js-line-number" data-line-number="173"></td>
        <td id="LC173" class="blob-code blob-code-inner js-file-line">  out(p63(<span class="pl-c1">1</span>, <span class="pl-c1">&#39;x&#39;</span>)) <span class="pl-k">===</span> <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>)</td>
      </tr>
      <tr>
        <td id="L174" class="blob-num js-line-number" data-line-number="174"></td>
        <td id="LC174" class="blob-code blob-code-inner js-file-line">  out(p63(<span class="pl-c1">2</span>, <span class="pl-c1">&#39;x&#39;</span>)) <span class="pl-k">===</span> <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>), <span class="pl-en">End</span>)</td>
      </tr>
      <tr>
        <td id="L175" class="blob-num js-line-number" data-line-number="175"></td>
        <td id="LC175" class="blob-code blob-code-inner js-file-line">  out(p63(<span class="pl-c1">3</span>, <span class="pl-c1">&#39;x&#39;</span>)) <span class="pl-k">===</span> <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>))</td>
      </tr>
      <tr>
        <td id="L176" class="blob-num js-line-number" data-line-number="176"></td>
        <td id="LC176" class="blob-code blob-code-inner js-file-line">  out(p63(<span class="pl-c1">4</span>, <span class="pl-c1">&#39;x&#39;</span>)) <span class="pl-k">===</span> <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>), <span class="pl-en">End</span>), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>))</td>
      </tr>
      <tr>
        <td id="L177" class="blob-num js-line-number" data-line-number="177"></td>
        <td id="LC177" class="blob-code blob-code-inner js-file-line">  out(p63(<span class="pl-c1">5</span>, <span class="pl-c1">&#39;x&#39;</span>)) <span class="pl-k">===</span> <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>)), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>))</td>
      </tr>
      <tr>
        <td id="L178" class="blob-num js-line-number" data-line-number="178"></td>
        <td id="LC178" class="blob-code blob-code-inner js-file-line">  out(p63(<span class="pl-c1">6</span>, <span class="pl-c1">&#39;x&#39;</span>)) <span class="pl-k">===</span> <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>)), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>), <span class="pl-en">End</span>))</td>
      </tr>
      <tr>
        <td id="L179" class="blob-num js-line-number" data-line-number="179"></td>
        <td id="LC179" class="blob-code blob-code-inner js-file-line">  out(p63(<span class="pl-c1">7</span>, <span class="pl-c1">&#39;x&#39;</span>)) <span class="pl-k">===</span> <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>)), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>)))</td>
      </tr>
      <tr>
        <td id="L180" class="blob-num js-line-number" data-line-number="180"></td>
        <td id="LC180" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L181" class="blob-num js-line-number" data-line-number="181"></td>
        <td id="LC181" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p63_2</span>[<span class="pl-en">T</span>](<span class="pl-v">number</span>: <span class="pl-k">Int</span>, <span class="pl-v">value</span>: <span class="pl-en">T</span>)<span class="pl-k">:</span> <span class="pl-en">Tree</span>[<span class="pl-en">T</span>] <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L182" class="blob-num js-line-number" data-line-number="182"></td>
        <td id="LC182" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">generateTree</span>(<span class="pl-v">addr</span>: <span class="pl-k">Int</span>)<span class="pl-k">:</span> <span class="pl-en">Tree</span>[<span class="pl-en">T</span>] <span class="pl-k">=</span></td>
      </tr>
      <tr>
        <td id="L183" class="blob-num js-line-number" data-line-number="183"></td>
        <td id="LC183" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">if</span> (addr <span class="pl-k">&gt;</span> number) <span class="pl-en">End</span></td>
      </tr>
      <tr>
        <td id="L184" class="blob-num js-line-number" data-line-number="184"></td>
        <td id="LC184" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">else</span> <span class="pl-en">Node</span>(value, generateTree(<span class="pl-c1">2</span> <span class="pl-k">*</span> addr), generateTree(<span class="pl-c1">2</span> <span class="pl-k">*</span> addr <span class="pl-k">+</span> <span class="pl-c1">1</span>))</td>
      </tr>
      <tr>
        <td id="L185" class="blob-num js-line-number" data-line-number="185"></td>
        <td id="LC185" class="blob-code blob-code-inner js-file-line">    generateTree(<span class="pl-c1">1</span>)</td>
      </tr>
      <tr>
        <td id="L186" class="blob-num js-line-number" data-line-number="186"></td>
        <td id="LC186" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L187" class="blob-num js-line-number" data-line-number="187"></td>
        <td id="LC187" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L188" class="blob-num js-line-number" data-line-number="188"></td>
        <td id="LC188" class="blob-code blob-code-inner js-file-line">  out(p63_2(<span class="pl-c1">1</span>, <span class="pl-c1">&#39;x&#39;</span>)) <span class="pl-k">===</span> <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>)</td>
      </tr>
      <tr>
        <td id="L189" class="blob-num js-line-number" data-line-number="189"></td>
        <td id="LC189" class="blob-code blob-code-inner js-file-line">  out(p63_2(<span class="pl-c1">2</span>, <span class="pl-c1">&#39;x&#39;</span>)) <span class="pl-k">===</span> <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>), <span class="pl-en">End</span>)</td>
      </tr>
      <tr>
        <td id="L190" class="blob-num js-line-number" data-line-number="190"></td>
        <td id="LC190" class="blob-code blob-code-inner js-file-line">  out(p63_2(<span class="pl-c1">3</span>, <span class="pl-c1">&#39;x&#39;</span>)) <span class="pl-k">===</span> <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>))</td>
      </tr>
      <tr>
        <td id="L191" class="blob-num js-line-number" data-line-number="191"></td>
        <td id="LC191" class="blob-code blob-code-inner js-file-line">  out(p63_2(<span class="pl-c1">4</span>, <span class="pl-c1">&#39;x&#39;</span>)) <span class="pl-k">===</span> <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>), <span class="pl-en">End</span>), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>))</td>
      </tr>
      <tr>
        <td id="L192" class="blob-num js-line-number" data-line-number="192"></td>
        <td id="LC192" class="blob-code blob-code-inner js-file-line">  out(p63_2(<span class="pl-c1">5</span>, <span class="pl-c1">&#39;x&#39;</span>)) <span class="pl-k">===</span> <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>)), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>))</td>
      </tr>
      <tr>
        <td id="L193" class="blob-num js-line-number" data-line-number="193"></td>
        <td id="LC193" class="blob-code blob-code-inner js-file-line">  out(p63_2(<span class="pl-c1">6</span>, <span class="pl-c1">&#39;x&#39;</span>)) <span class="pl-k">===</span> <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>)), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>), <span class="pl-en">End</span>))</td>
      </tr>
      <tr>
        <td id="L194" class="blob-num js-line-number" data-line-number="194"></td>
        <td id="LC194" class="blob-code blob-code-inner js-file-line">  out(p63_2(<span class="pl-c1">7</span>, <span class="pl-c1">&#39;x&#39;</span>)) <span class="pl-k">===</span> <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>)), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;x&#39;</span>)))</td>
      </tr>
      <tr>
        <td id="L195" class="blob-num js-line-number" data-line-number="195"></td>
        <td id="LC195" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L196" class="blob-num js-line-number" data-line-number="196"></td>
        <td id="LC196" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">--------------</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>P64. Layout a binary tree(1)<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L197" class="blob-num js-line-number" data-line-number="197"></td>
        <td id="LC197" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L198" class="blob-num js-line-number" data-line-number="198"></td>
        <td id="LC198" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">class</span> <span class="pl-en">PositionedNode</span>[<span class="pl-k">+</span><span class="pl-en">T</span>](<span class="pl-k">override</span> <span class="pl-k">val</span> <span class="pl-en">value</span><span class="pl-k">:</span> <span class="pl-en">T</span>, <span class="pl-k">override</span> <span class="pl-k">val</span> <span class="pl-en">left</span><span class="pl-k">:</span> <span class="pl-en">Tree</span>[<span class="pl-en">T</span>], <span class="pl-k">override</span> <span class="pl-k">val</span> <span class="pl-en">right</span><span class="pl-k">:</span> <span class="pl-en">Tree</span>[<span class="pl-en">T</span>], <span class="pl-k">val</span> <span class="pl-en">x</span><span class="pl-k">:</span> <span class="pl-k">Int</span>, <span class="pl-k">val</span> <span class="pl-en">y</span><span class="pl-k">:</span> <span class="pl-k">Int</span>)</td>
      </tr>
      <tr>
        <td id="L199" class="blob-num js-line-number" data-line-number="199"></td>
        <td id="LC199" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">extends</span> <span class="pl-e">Node</span>[<span class="pl-en">T</span>](value, left, right){</td>
      </tr>
      <tr>
        <td id="L200" class="blob-num js-line-number" data-line-number="200"></td>
        <td id="LC200" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">override</span> <span class="pl-k">def</span> <span class="pl-en">toString</span> <span class="pl-k">=</span> s<span class="pl-s"><span class="pl-pds">&quot;</span>T[$x, $y]($value $left $right)<span class="pl-pds">&quot;</span></span></td>
      </tr>
      <tr>
        <td id="L201" class="blob-num js-line-number" data-line-number="201"></td>
        <td id="LC201" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L202" class="blob-num js-line-number" data-line-number="202"></td>
        <td id="LC202" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L203" class="blob-num js-line-number" data-line-number="203"></td>
        <td id="LC203" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">object</span> <span class="pl-en">PositionedNode</span> {</td>
      </tr>
      <tr>
        <td id="L204" class="blob-num js-line-number" data-line-number="204"></td>
        <td id="LC204" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">unapply</span>[<span class="pl-en">T</span>](<span class="pl-v">p</span>: <span class="pl-en">PositionedNode</span>[<span class="pl-en">T</span>]) <span class="pl-k">:</span> <span class="pl-en">Option</span>[(<span class="pl-en">T</span>, <span class="pl-en">Tree</span>[<span class="pl-en">T</span>], <span class="pl-en">Tree</span>[<span class="pl-en">T</span>], <span class="pl-k">Int</span>, <span class="pl-k">Int</span>)] <span class="pl-k">=</span></td>
      </tr>
      <tr>
        <td id="L205" class="blob-num js-line-number" data-line-number="205"></td>
        <td id="LC205" class="blob-code blob-code-inner js-file-line">      <span class="pl-en">Some</span>(p.value, p.left, p.right, p.x, p.y)</td>
      </tr>
      <tr>
        <td id="L206" class="blob-num js-line-number" data-line-number="206"></td>
        <td id="LC206" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L207" class="blob-num js-line-number" data-line-number="207"></td>
        <td id="LC207" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">apply</span>[<span class="pl-en">T</span>](<span class="pl-v">value</span>: <span class="pl-en">T</span>, <span class="pl-v">left</span>: <span class="pl-en">Tree</span>[<span class="pl-en">T</span>], <span class="pl-v">right</span>: <span class="pl-en">Tree</span>[<span class="pl-en">T</span>], <span class="pl-v">x</span>: <span class="pl-k">Int</span>, <span class="pl-v">y</span>: <span class="pl-k">Int</span>) <span class="pl-k">=</span></td>
      </tr>
      <tr>
        <td id="L208" class="blob-num js-line-number" data-line-number="208"></td>
        <td id="LC208" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">new</span> <span class="pl-en">PositionedNode</span>[<span class="pl-en">T</span>](value, left, right, x, y)</td>
      </tr>
      <tr>
        <td id="L209" class="blob-num js-line-number" data-line-number="209"></td>
        <td id="LC209" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L210" class="blob-num js-line-number" data-line-number="210"></td>
        <td id="LC210" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">apply</span>[<span class="pl-en">T</span>](<span class="pl-v">value</span>: <span class="pl-en">T</span>, <span class="pl-v">x</span>: <span class="pl-k">Int</span>, <span class="pl-v">y</span>: <span class="pl-k">Int</span>) <span class="pl-k">=</span></td>
      </tr>
      <tr>
        <td id="L211" class="blob-num js-line-number" data-line-number="211"></td>
        <td id="LC211" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">new</span> <span class="pl-en">PositionedNode</span>[<span class="pl-en">T</span>](value, <span class="pl-en">End</span>, <span class="pl-en">End</span>, x, y)</td>
      </tr>
      <tr>
        <td id="L212" class="blob-num js-line-number" data-line-number="212"></td>
        <td id="LC212" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L213" class="blob-num js-line-number" data-line-number="213"></td>
        <td id="LC213" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L214" class="blob-num js-line-number" data-line-number="214"></td>
        <td id="LC214" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">drawTree</span>[<span class="pl-en">T</span>](<span class="pl-v">positionedNode</span>: <span class="pl-en">Tree</span>[<span class="pl-en">T</span>])<span class="pl-k">:</span> <span class="pl-k">Unit</span> <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L215" class="blob-num js-line-number" data-line-number="215"></td>
        <td id="LC215" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">collect</span>(<span class="pl-v">positionedNode</span>: <span class="pl-en">Tree</span>[<span class="pl-en">T</span>]) <span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-en">PositionedNode</span>[<span class="pl-en">T</span>]] <span class="pl-k">=</span> positionedNode <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L216" class="blob-num js-line-number" data-line-number="216"></td>
        <td id="LC216" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-en">End</span> <span class="pl-k">=&gt;</span> <span class="pl-c1">Nil</span></td>
      </tr>
      <tr>
        <td id="L217" class="blob-num js-line-number" data-line-number="217"></td>
        <td id="LC217" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> a<span class="pl-k">@</span><span class="pl-en">PositionedNode</span>(_, left, right, _, _) <span class="pl-k">=&gt;</span> a <span class="pl-k">::</span> collect(left) <span class="pl-k">:::</span> collect(right)</td>
      </tr>
      <tr>
        <td id="L218" class="blob-num js-line-number" data-line-number="218"></td>
        <td id="LC218" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L219" class="blob-num js-line-number" data-line-number="219"></td>
        <td id="LC219" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L220" class="blob-num js-line-number" data-line-number="220"></td>
        <td id="LC220" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">val</span> <span class="pl-en">sorted</span> <span class="pl-k">=</span> collect(positionedNode) groupBy { _.y }</td>
      </tr>
      <tr>
        <td id="L221" class="blob-num js-line-number" data-line-number="221"></td>
        <td id="LC221" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">for</span> (key <span class="pl-k">&lt;</span><span class="pl-k">-</span> <span class="pl-c1">0</span> to sorted.keys.toSeq.max) sorted.get(key) <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L222" class="blob-num js-line-number" data-line-number="222"></td>
        <td id="LC222" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-c1">None</span> <span class="pl-k">=&gt;</span> println(<span class="pl-s"><span class="pl-pds">&quot;</span><span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L223" class="blob-num js-line-number" data-line-number="223"></td>
        <td id="LC223" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-en">Some</span>(value) <span class="pl-k">=&gt;</span></td>
      </tr>
      <tr>
        <td id="L224" class="blob-num js-line-number" data-line-number="224"></td>
        <td id="LC224" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">val</span> <span class="pl-en">left</span> <span class="pl-k">=</span> value.sortBy(_.x).foldLeft(<span class="pl-s"><span class="pl-pds">&quot;</span><span class="pl-pds">&quot;</span></span>)((acc, value) <span class="pl-k">=&gt;</span> acc <span class="pl-k">+</span> (<span class="pl-s"><span class="pl-pds">&quot;</span> <span class="pl-pds">&quot;</span></span> <span class="pl-k">*</span> (math.max(value.x <span class="pl-k">-</span> acc.length <span class="pl-k">+</span> <span class="pl-c1">1</span>, <span class="pl-c1">0</span>))) <span class="pl-k">+</span> value.value.toString)</td>
      </tr>
      <tr>
        <td id="L225" class="blob-num js-line-number" data-line-number="225"></td>
        <td id="LC225" class="blob-code blob-code-inner js-file-line">        println(left)</td>
      </tr>
      <tr>
        <td id="L226" class="blob-num js-line-number" data-line-number="226"></td>
        <td id="LC226" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L227" class="blob-num js-line-number" data-line-number="227"></td>
        <td id="LC227" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L228" class="blob-num js-line-number" data-line-number="228"></td>
        <td id="LC228" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L229" class="blob-num js-line-number" data-line-number="229"></td>
        <td id="LC229" class="blob-code blob-code-inner js-file-line">  <span class="pl-c">//drawTree(PositionedNode(&#39;A&#39;, PositionedNode(&#39;B&#39;, 3, 2), End, 2, 2))</span></td>
      </tr>
      <tr>
        <td id="L230" class="blob-num js-line-number" data-line-number="230"></td>
        <td id="LC230" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L231" class="blob-num js-line-number" data-line-number="231"></td>
        <td id="LC231" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p64</span>[<span class="pl-en">T</span>](<span class="pl-v">tree</span>: <span class="pl-en">Tree</span>[<span class="pl-en">T</span>])<span class="pl-k">:</span> <span class="pl-en">Tree</span>[<span class="pl-en">T</span>] <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L232" class="blob-num js-line-number" data-line-number="232"></td>
        <td id="LC232" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">count</span>(<span class="pl-v">tree</span>: <span class="pl-en">Tree</span>[<span class="pl-en">T</span>])<span class="pl-k">:</span> <span class="pl-k">Int</span> <span class="pl-k">=</span> tree <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L233" class="blob-num js-line-number" data-line-number="233"></td>
        <td id="LC233" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-en">End</span> <span class="pl-k">=&gt;</span> <span class="pl-c1">0</span></td>
      </tr>
      <tr>
        <td id="L234" class="blob-num js-line-number" data-line-number="234"></td>
        <td id="LC234" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-en">Node</span>(_, l, r) <span class="pl-k">=&gt;</span> count(l) <span class="pl-k">+</span> count(r) <span class="pl-k">+</span> <span class="pl-c1">1</span></td>
      </tr>
      <tr>
        <td id="L235" class="blob-num js-line-number" data-line-number="235"></td>
        <td id="LC235" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L236" class="blob-num js-line-number" data-line-number="236"></td>
        <td id="LC236" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L237" class="blob-num js-line-number" data-line-number="237"></td>
        <td id="LC237" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">inner</span>(<span class="pl-v">tree</span>: <span class="pl-en">Tree</span>[<span class="pl-en">T</span>], <span class="pl-v">y</span>: <span class="pl-k">Int</span>, <span class="pl-v">x</span>: <span class="pl-k">Int</span>)<span class="pl-k">:</span> <span class="pl-en">Tree</span>[<span class="pl-en">T</span>] <span class="pl-k">=</span> tree <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L238" class="blob-num js-line-number" data-line-number="238"></td>
        <td id="LC238" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-en">End</span> <span class="pl-k">=&gt;</span> <span class="pl-en">End</span></td>
      </tr>
      <tr>
        <td id="L239" class="blob-num js-line-number" data-line-number="239"></td>
        <td id="LC239" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-en">Node</span>(v, l, r) <span class="pl-k">=&gt;</span></td>
      </tr>
      <tr>
        <td id="L240" class="blob-num js-line-number" data-line-number="240"></td>
        <td id="LC240" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">val</span> <span class="pl-en">leftCount</span> <span class="pl-k">=</span> count(l)</td>
      </tr>
      <tr>
        <td id="L241" class="blob-num js-line-number" data-line-number="241"></td>
        <td id="LC241" class="blob-code blob-code-inner js-file-line">        <span class="pl-en">PositionedNode</span>(v, inner(l, y <span class="pl-k">+</span> <span class="pl-c1">1</span>, x), inner(r, y <span class="pl-k">+</span> <span class="pl-c1">1</span>, leftCount <span class="pl-k">+</span> x <span class="pl-k">+</span> <span class="pl-c1">1</span>), leftCount <span class="pl-k">+</span> x <span class="pl-k">+</span> <span class="pl-c1">1</span>, y)</td>
      </tr>
      <tr>
        <td id="L242" class="blob-num js-line-number" data-line-number="242"></td>
        <td id="LC242" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L243" class="blob-num js-line-number" data-line-number="243"></td>
        <td id="LC243" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L244" class="blob-num js-line-number" data-line-number="244"></td>
        <td id="LC244" class="blob-code blob-code-inner js-file-line">    inner(tree, <span class="pl-c1">0</span>, <span class="pl-c1">0</span>)</td>
      </tr>
      <tr>
        <td id="L245" class="blob-num js-line-number" data-line-number="245"></td>
        <td id="LC245" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L246" class="blob-num js-line-number" data-line-number="246"></td>
        <td id="LC246" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L247" class="blob-num js-line-number" data-line-number="247"></td>
        <td id="LC247" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">val</span> <span class="pl-en">p64_input</span> <span class="pl-k">=</span> <span class="pl-en">Node</span>(<span class="pl-c1">&#39;n&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;k&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;c&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;a&#39;</span>), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;h&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;g&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;e&#39;</span>), <span class="pl-en">End</span>), <span class="pl-en">End</span>)), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;m&#39;</span>)), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;u&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;p&#39;</span>, <span class="pl-en">End</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;s&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;q&#39;</span>), <span class="pl-en">End</span>)), <span class="pl-en">End</span>))</td>
      </tr>
      <tr>
        <td id="L248" class="blob-num js-line-number" data-line-number="248"></td>
        <td id="LC248" class="blob-code blob-code-inner js-file-line">  drawTree(p64(p64_input))</td>
      </tr>
      <tr>
        <td id="L249" class="blob-num js-line-number" data-line-number="249"></td>
        <td id="LC249" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L250" class="blob-num js-line-number" data-line-number="250"></td>
        <td id="LC250" class="blob-code blob-code-inner js-file-line">  <span class="pl-c">// The same as p64, but count is returned with the recursion</span></td>
      </tr>
      <tr>
        <td id="L251" class="blob-num js-line-number" data-line-number="251"></td>
        <td id="LC251" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p64_2</span>[<span class="pl-en">T</span>](<span class="pl-v">tree</span>: <span class="pl-en">Tree</span>[<span class="pl-en">T</span>])<span class="pl-k">:</span> <span class="pl-en">Tree</span>[<span class="pl-en">T</span>] <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L252" class="blob-num js-line-number" data-line-number="252"></td>
        <td id="LC252" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">inner</span>(<span class="pl-v">tree</span>: <span class="pl-en">Tree</span>[<span class="pl-en">T</span>], <span class="pl-v">x</span>: <span class="pl-k">Int</span>, <span class="pl-v">depth</span>: <span class="pl-k">Int</span>)<span class="pl-k">:</span> (<span class="pl-en">Tree</span>[<span class="pl-en">T</span>], <span class="pl-k">Int</span>) <span class="pl-k">=</span> tree <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L253" class="blob-num js-line-number" data-line-number="253"></td>
        <td id="LC253" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-en">End</span> <span class="pl-k">=&gt;</span> (<span class="pl-en">End</span>, x)  <span class="pl-c">// We count elements by x</span></td>
      </tr>
      <tr>
        <td id="L254" class="blob-num js-line-number" data-line-number="254"></td>
        <td id="LC254" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-en">Node</span>(v, l, r) <span class="pl-k">=&gt;</span></td>
      </tr>
      <tr>
        <td id="L255" class="blob-num js-line-number" data-line-number="255"></td>
        <td id="LC255" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">val</span> (leftTree, myX) <span class="pl-k">=</span> inner(l, x, depth <span class="pl-k">+</span> <span class="pl-c1">1</span>)</td>
      </tr>
      <tr>
        <td id="L256" class="blob-num js-line-number" data-line-number="256"></td>
        <td id="LC256" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">val</span> (rightTree, nextX) <span class="pl-k">=</span> inner(r, myX <span class="pl-k">+</span> <span class="pl-c1">1</span>, depth <span class="pl-k">+</span> <span class="pl-c1">1</span>)</td>
      </tr>
      <tr>
        <td id="L257" class="blob-num js-line-number" data-line-number="257"></td>
        <td id="LC257" class="blob-code blob-code-inner js-file-line">        (<span class="pl-en">PositionedNode</span>(v, leftTree, rightTree, myX, depth), nextX)</td>
      </tr>
      <tr>
        <td id="L258" class="blob-num js-line-number" data-line-number="258"></td>
        <td id="LC258" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L259" class="blob-num js-line-number" data-line-number="259"></td>
        <td id="LC259" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L260" class="blob-num js-line-number" data-line-number="260"></td>
        <td id="LC260" class="blob-code blob-code-inner js-file-line">    inner(tree, <span class="pl-c1">1</span>, <span class="pl-c1">1</span>)._1</td>
      </tr>
      <tr>
        <td id="L261" class="blob-num js-line-number" data-line-number="261"></td>
        <td id="LC261" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L262" class="blob-num js-line-number" data-line-number="262"></td>
        <td id="LC262" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L263" class="blob-num js-line-number" data-line-number="263"></td>
        <td id="LC263" class="blob-code blob-code-inner js-file-line">  drawTree(p64_2(p64_input))</td>
      </tr>
      <tr>
        <td id="L264" class="blob-num js-line-number" data-line-number="264"></td>
        <td id="LC264" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L265" class="blob-num js-line-number" data-line-number="265"></td>
        <td id="LC265" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">--------------</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>P65. Layout a binary tree (2)<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L266" class="blob-num js-line-number" data-line-number="266"></td>
        <td id="LC266" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L267" class="blob-num js-line-number" data-line-number="267"></td>
        <td id="LC267" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p65</span>[<span class="pl-en">T</span>](<span class="pl-v">tree</span>: <span class="pl-en">Tree</span>[<span class="pl-en">T</span>])<span class="pl-k">:</span> <span class="pl-en">Tree</span>[<span class="pl-en">T</span>] <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L268" class="blob-num js-line-number" data-line-number="268"></td>
        <td id="LC268" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">treeDepth</span>(<span class="pl-v">tree</span>: <span class="pl-en">Tree</span>[<span class="pl-en">T</span>])<span class="pl-k">:</span> <span class="pl-k">Int</span> <span class="pl-k">=</span> tree <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L269" class="blob-num js-line-number" data-line-number="269"></td>
        <td id="LC269" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-en">End</span> <span class="pl-k">=&gt;</span> <span class="pl-c1">0</span></td>
      </tr>
      <tr>
        <td id="L270" class="blob-num js-line-number" data-line-number="270"></td>
        <td id="LC270" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-en">Node</span>(_, l, r) <span class="pl-k">=&gt;</span> (treeDepth(l) max treeDepth(r)) <span class="pl-k">+</span> <span class="pl-c1">1</span></td>
      </tr>
      <tr>
        <td id="L271" class="blob-num js-line-number" data-line-number="271"></td>
        <td id="LC271" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L272" class="blob-num js-line-number" data-line-number="272"></td>
        <td id="LC272" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L273" class="blob-num js-line-number" data-line-number="273"></td>
        <td id="LC273" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">leftmostNodeDepth</span>(<span class="pl-v">tree</span>: <span class="pl-en">Tree</span>[<span class="pl-en">T</span>])<span class="pl-k">:</span> <span class="pl-k">Int</span> <span class="pl-k">=</span> tree <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L274" class="blob-num js-line-number" data-line-number="274"></td>
        <td id="LC274" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-en">End</span> <span class="pl-k">=&gt;</span> <span class="pl-c1">0</span></td>
      </tr>
      <tr>
        <td id="L275" class="blob-num js-line-number" data-line-number="275"></td>
        <td id="LC275" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-en">Node</span>(_, l, _) <span class="pl-k">=&gt;</span> leftmostNodeDepth(l) <span class="pl-k">+</span> <span class="pl-c1">1</span></td>
      </tr>
      <tr>
        <td id="L276" class="blob-num js-line-number" data-line-number="276"></td>
        <td id="LC276" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L277" class="blob-num js-line-number" data-line-number="277"></td>
        <td id="LC277" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L278" class="blob-num js-line-number" data-line-number="278"></td>
        <td id="LC278" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">inner</span>(<span class="pl-v">tree</span>: <span class="pl-en">Tree</span>[<span class="pl-en">T</span>], <span class="pl-v">x</span>: <span class="pl-k">Int</span>, <span class="pl-v">depth</span>: <span class="pl-k">Int</span>, <span class="pl-v">exp</span>: <span class="pl-k">Int</span>)<span class="pl-k">:</span> <span class="pl-en">Tree</span>[<span class="pl-en">T</span>] <span class="pl-k">=</span> tree <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L279" class="blob-num js-line-number" data-line-number="279"></td>
        <td id="LC279" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-en">End</span> <span class="pl-k">=&gt;</span> <span class="pl-en">End</span></td>
      </tr>
      <tr>
        <td id="L280" class="blob-num js-line-number" data-line-number="280"></td>
        <td id="LC280" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-en">Node</span>(v, l, r) <span class="pl-k">=&gt;</span></td>
      </tr>
      <tr>
        <td id="L281" class="blob-num js-line-number" data-line-number="281"></td>
        <td id="LC281" class="blob-code blob-code-inner js-file-line">        <span class="pl-en">PositionedNode</span>(v,</td>
      </tr>
      <tr>
        <td id="L282" class="blob-num js-line-number" data-line-number="282"></td>
        <td id="LC282" class="blob-code blob-code-inner js-file-line">        inner(l, x <span class="pl-k">-</span> math.pow(<span class="pl-c1">2</span>, exp).toInt, depth <span class="pl-k">+</span> <span class="pl-c1">1</span>, exp <span class="pl-k">-</span> <span class="pl-c1">1</span>),</td>
      </tr>
      <tr>
        <td id="L283" class="blob-num js-line-number" data-line-number="283"></td>
        <td id="LC283" class="blob-code blob-code-inner js-file-line">        inner(r, x <span class="pl-k">+</span> math.pow(<span class="pl-c1">2</span>, exp).toInt, depth <span class="pl-k">+</span> <span class="pl-c1">1</span>, exp <span class="pl-k">-</span> <span class="pl-c1">1</span>),</td>
      </tr>
      <tr>
        <td id="L284" class="blob-num js-line-number" data-line-number="284"></td>
        <td id="LC284" class="blob-code blob-code-inner js-file-line">        x, depth)</td>
      </tr>
      <tr>
        <td id="L285" class="blob-num js-line-number" data-line-number="285"></td>
        <td id="LC285" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L286" class="blob-num js-line-number" data-line-number="286"></td>
        <td id="LC286" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L287" class="blob-num js-line-number" data-line-number="287"></td>
        <td id="LC287" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">val</span> <span class="pl-en">d</span> <span class="pl-k">=</span> treeDepth(tree)</td>
      </tr>
      <tr>
        <td id="L288" class="blob-num js-line-number" data-line-number="288"></td>
        <td id="LC288" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">val</span> <span class="pl-en">x0</span> <span class="pl-k">=</span> ((<span class="pl-c1">2</span> to leftmostNodeDepth(tree)) map {n <span class="pl-k">=&gt;</span> math.pow(<span class="pl-c1">2</span>, d <span class="pl-k">-</span> n).toInt} reduceLeft {_ <span class="pl-k">+</span> _}) <span class="pl-k">+</span> <span class="pl-c1">1</span></td>
      </tr>
      <tr>
        <td id="L289" class="blob-num js-line-number" data-line-number="289"></td>
        <td id="LC289" class="blob-code blob-code-inner js-file-line">    inner(tree, x0, <span class="pl-c1">1</span>, d <span class="pl-k">-</span> <span class="pl-c1">2</span>)</td>
      </tr>
      <tr>
        <td id="L290" class="blob-num js-line-number" data-line-number="290"></td>
        <td id="LC290" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L291" class="blob-num js-line-number" data-line-number="291"></td>
        <td id="LC291" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L292" class="blob-num js-line-number" data-line-number="292"></td>
        <td id="LC292" class="blob-code blob-code-inner js-file-line">  drawTree(p65(p64_input))</td>
      </tr>
      <tr>
        <td id="L293" class="blob-num js-line-number" data-line-number="293"></td>
        <td id="LC293" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L294" class="blob-num js-line-number" data-line-number="294"></td>
        <td id="LC294" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">--------------</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>P66. Layout a binary tree (3)<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L295" class="blob-num js-line-number" data-line-number="295"></td>
        <td id="LC295" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p66</span>[<span class="pl-en">T</span>](<span class="pl-v">tree</span>: <span class="pl-en">Tree</span>[<span class="pl-en">T</span>])<span class="pl-k">:</span> <span class="pl-en">Tree</span>[<span class="pl-en">T</span>] <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L296" class="blob-num js-line-number" data-line-number="296"></td>
        <td id="LC296" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">lowerBounds</span>(<span class="pl-v">tree</span>: <span class="pl-en">Node</span>[<span class="pl-en">T</span>]) <span class="pl-k">=</span> (bounds(tree.left), bounds(tree.right)) <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L297" class="blob-num js-line-number" data-line-number="297"></td>
        <td id="LC297" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> (<span class="pl-c1">Nil</span>, <span class="pl-c1">Nil</span>) <span class="pl-k">=&gt;</span> <span class="pl-c1">Nil</span></td>
      </tr>
      <tr>
        <td id="L298" class="blob-num js-line-number" data-line-number="298"></td>
        <td id="LC298" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> (lb, <span class="pl-c1">Nil</span>) <span class="pl-k">=&gt;</span> lb map { <span class="pl-k">case</span> (a, b) <span class="pl-k">=&gt;</span> (a <span class="pl-k">-</span> <span class="pl-c1">1</span>, b <span class="pl-k">-</span> <span class="pl-c1">1</span>) }</td>
      </tr>
      <tr>
        <td id="L299" class="blob-num js-line-number" data-line-number="299"></td>
        <td id="LC299" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> (<span class="pl-c1">Nil</span>, rb) <span class="pl-k">=&gt;</span> rb map { <span class="pl-k">case</span> (a, b) <span class="pl-k">=&gt;</span> (a <span class="pl-k">+</span> <span class="pl-c1">1</span>, b <span class="pl-k">+</span> <span class="pl-c1">1</span>) }</td>
      </tr>
      <tr>
        <td id="L300" class="blob-num js-line-number" data-line-number="300"></td>
        <td id="LC300" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> (a, b) <span class="pl-k">=&gt;</span> {</td>
      </tr>
      <tr>
        <td id="L301" class="blob-num js-line-number" data-line-number="301"></td>
        <td id="LC301" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">val</span> <span class="pl-en">shift</span> <span class="pl-k">=</span> a.zip(b) map { <span class="pl-k">case</span> ((la, ra), (lb, rb)) <span class="pl-k">=&gt;</span> (ra <span class="pl-k">-</span> lb) <span class="pl-k">/</span> <span class="pl-c1">2</span> <span class="pl-k">+</span> <span class="pl-c1">1</span>} reduceLeft {_ max _}</td>
      </tr>
      <tr>
        <td id="L302" class="blob-num js-line-number" data-line-number="302"></td>
        <td id="LC302" class="blob-code blob-code-inner js-file-line">        (a map { <span class="pl-en">Some</span>(_) }).zipAll(b map {<span class="pl-en">Some</span>(_)}, <span class="pl-c1">None</span>, <span class="pl-c1">None</span>) map {</td>
      </tr>
      <tr>
        <td id="L303" class="blob-num js-line-number" data-line-number="303"></td>
        <td id="LC303" class="blob-code blob-code-inner js-file-line">          <span class="pl-k">case</span> (<span class="pl-en">Some</span>((a, b)), <span class="pl-en">Some</span>((c, d))) <span class="pl-k">=&gt;</span> (a <span class="pl-k">-</span> shift, d <span class="pl-k">+</span> shift)</td>
      </tr>
      <tr>
        <td id="L304" class="blob-num js-line-number" data-line-number="304"></td>
        <td id="LC304" class="blob-code blob-code-inner js-file-line">          <span class="pl-k">case</span> (<span class="pl-en">Some</span>((a, b)), <span class="pl-c1">None</span>)         <span class="pl-k">=&gt;</span> (a <span class="pl-k">-</span> shift, b <span class="pl-k">-</span> shift)</td>
      </tr>
      <tr>
        <td id="L305" class="blob-num js-line-number" data-line-number="305"></td>
        <td id="LC305" class="blob-code blob-code-inner js-file-line">          <span class="pl-k">case</span> (<span class="pl-c1">None</span>, <span class="pl-en">Some</span>((c, d)))         <span class="pl-k">=&gt;</span> (c <span class="pl-k">+</span> shift, d <span class="pl-k">+</span> shift)</td>
      </tr>
      <tr>
        <td id="L306" class="blob-num js-line-number" data-line-number="306"></td>
        <td id="LC306" class="blob-code blob-code-inner js-file-line">          <span class="pl-k">case</span> _ <span class="pl-k">=&gt;</span> <span class="pl-k">???</span></td>
      </tr>
      <tr>
        <td id="L307" class="blob-num js-line-number" data-line-number="307"></td>
        <td id="LC307" class="blob-code blob-code-inner js-file-line">        }</td>
      </tr>
      <tr>
        <td id="L308" class="blob-num js-line-number" data-line-number="308"></td>
        <td id="LC308" class="blob-code blob-code-inner js-file-line">      }</td>
      </tr>
      <tr>
        <td id="L309" class="blob-num js-line-number" data-line-number="309"></td>
        <td id="LC309" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L310" class="blob-num js-line-number" data-line-number="310"></td>
        <td id="LC310" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">bounds</span>(<span class="pl-v">tree</span>: <span class="pl-en">Tree</span>[<span class="pl-en">T</span>])<span class="pl-k">:</span> <span class="pl-en">List</span>[(<span class="pl-k">Int</span>, <span class="pl-k">Int</span>)] <span class="pl-k">=</span> tree <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L311" class="blob-num js-line-number" data-line-number="311"></td>
        <td id="LC311" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-v">a</span> : <span class="pl-en">Node</span>[<span class="pl-en">T</span>] <span class="pl-k">=&gt;</span> (<span class="pl-c1">0</span>, <span class="pl-c1">0</span>) <span class="pl-k">::</span> lowerBounds(a)</td>
      </tr>
      <tr>
        <td id="L312" class="blob-num js-line-number" data-line-number="312"></td>
        <td id="LC312" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-en">End</span> <span class="pl-k">=&gt;</span> <span class="pl-c1">Nil</span></td>
      </tr>
      <tr>
        <td id="L313" class="blob-num js-line-number" data-line-number="313"></td>
        <td id="LC313" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L314" class="blob-num js-line-number" data-line-number="314"></td>
        <td id="LC314" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L315" class="blob-num js-line-number" data-line-number="315"></td>
        <td id="LC315" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">internal</span>(<span class="pl-v">tree</span>: <span class="pl-en">Tree</span>[<span class="pl-en">T</span>], <span class="pl-v">x</span>: <span class="pl-k">Int</span>, <span class="pl-v">depth</span>: <span class="pl-k">Int</span>)<span class="pl-k">:</span> <span class="pl-en">Tree</span>[<span class="pl-en">T</span>] <span class="pl-k">=</span></td>
      </tr>
      <tr>
        <td id="L316" class="blob-num js-line-number" data-line-number="316"></td>
        <td id="LC316" class="blob-code blob-code-inner js-file-line">      (tree, bounds(tree)) <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L317" class="blob-num js-line-number" data-line-number="317"></td>
        <td id="LC317" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> (<span class="pl-en">End</span>, _) <span class="pl-k">=&gt;</span> <span class="pl-en">End</span></td>
      </tr>
      <tr>
        <td id="L318" class="blob-num js-line-number" data-line-number="318"></td>
        <td id="LC318" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> (<span class="pl-en">Node</span>(v, l, r), _ <span class="pl-k">::</span> (bl, br) <span class="pl-k">::</span> _) <span class="pl-k">=&gt;</span></td>
      </tr>
      <tr>
        <td id="L319" class="blob-num js-line-number" data-line-number="319"></td>
        <td id="LC319" class="blob-code blob-code-inner js-file-line">          <span class="pl-en">PositionedNode</span>(v, internal(l, x <span class="pl-k">+</span> bl, depth <span class="pl-k">+</span> <span class="pl-c1">1</span>), internal(r, x <span class="pl-k">+</span> br, depth <span class="pl-k">+</span> <span class="pl-c1">1</span>), x, depth)</td>
      </tr>
      <tr>
        <td id="L320" class="blob-num js-line-number" data-line-number="320"></td>
        <td id="LC320" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> (<span class="pl-en">Node</span>(v, l, r), _) <span class="pl-k">=&gt;</span> <span class="pl-en">PositionedNode</span>(v, <span class="pl-en">End</span>, <span class="pl-en">End</span>, x, depth)</td>
      </tr>
      <tr>
        <td id="L321" class="blob-num js-line-number" data-line-number="321"></td>
        <td id="LC321" class="blob-code blob-code-inner js-file-line">      }</td>
      </tr>
      <tr>
        <td id="L322" class="blob-num js-line-number" data-line-number="322"></td>
        <td id="LC322" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L323" class="blob-num js-line-number" data-line-number="323"></td>
        <td id="LC323" class="blob-code blob-code-inner js-file-line">    internal(tree, (bounds(tree) map { <span class="pl-k">case</span>(x, y) <span class="pl-k">=&gt;</span> x} reduceLeft {_ min _}) <span class="pl-k">*</span> <span class="pl-k">-</span><span class="pl-c1">1</span> <span class="pl-k">+</span> <span class="pl-c1">1</span>, <span class="pl-c1">1</span>)</td>
      </tr>
      <tr>
        <td id="L324" class="blob-num js-line-number" data-line-number="324"></td>
        <td id="LC324" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L325" class="blob-num js-line-number" data-line-number="325"></td>
        <td id="LC325" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L326" class="blob-num js-line-number" data-line-number="326"></td>
        <td id="LC326" class="blob-code blob-code-inner js-file-line">  drawTree(p66(p64_input))</td>
      </tr>
      <tr>
        <td id="L327" class="blob-num js-line-number" data-line-number="327"></td>
        <td id="LC327" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L328" class="blob-num js-line-number" data-line-number="328"></td>
        <td id="LC328" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L329" class="blob-num js-line-number" data-line-number="329"></td>
        <td id="LC329" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">--------------</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>P67. A string representation of a binary tree.<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L330" class="blob-num js-line-number" data-line-number="330"></td>
        <td id="LC330" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p67</span>[<span class="pl-en">T</span>](<span class="pl-v">tree</span>: <span class="pl-en">Tree</span>[<span class="pl-en">T</span>])<span class="pl-k">:</span> <span class="pl-k">String</span> <span class="pl-k">=</span> tree <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L331" class="blob-num js-line-number" data-line-number="331"></td>
        <td id="LC331" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> <span class="pl-en">End</span> <span class="pl-k">=&gt;</span> <span class="pl-s"><span class="pl-pds">&quot;</span><span class="pl-pds">&quot;</span></span></td>
      </tr>
      <tr>
        <td id="L332" class="blob-num js-line-number" data-line-number="332"></td>
        <td id="LC332" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> <span class="pl-en">Node</span>(v, <span class="pl-en">End</span>, <span class="pl-en">End</span>) <span class="pl-k">=&gt;</span> v.toString</td>
      </tr>
      <tr>
        <td id="L333" class="blob-num js-line-number" data-line-number="333"></td>
        <td id="LC333" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> <span class="pl-en">Node</span>(v, l, <span class="pl-en">End</span>) <span class="pl-k">=&gt;</span> s<span class="pl-s"><span class="pl-pds">&quot;</span>$v(${p67(l)},)<span class="pl-pds">&quot;</span></span></td>
      </tr>
      <tr>
        <td id="L334" class="blob-num js-line-number" data-line-number="334"></td>
        <td id="LC334" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> <span class="pl-en">Node</span>(v, <span class="pl-en">End</span>, r) <span class="pl-k">=&gt;</span> s<span class="pl-s"><span class="pl-pds">&quot;</span>$v(,${p67(r)})<span class="pl-pds">&quot;</span></span></td>
      </tr>
      <tr>
        <td id="L335" class="blob-num js-line-number" data-line-number="335"></td>
        <td id="LC335" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> <span class="pl-en">Node</span>(v, l, r) <span class="pl-k">=&gt;</span> s<span class="pl-s"><span class="pl-pds">&quot;</span>$v(${p67(l)},${p67(r)})<span class="pl-pds">&quot;</span></span></td>
      </tr>
      <tr>
        <td id="L336" class="blob-num js-line-number" data-line-number="336"></td>
        <td id="LC336" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L337" class="blob-num js-line-number" data-line-number="337"></td>
        <td id="LC337" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L338" class="blob-num js-line-number" data-line-number="338"></td>
        <td id="LC338" class="blob-code blob-code-inner js-file-line">  out(p67(<span class="pl-en">Node</span>(<span class="pl-c1">&#39;a&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;b&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;d&#39;</span>), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;e&#39;</span>)), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;c&#39;</span>, <span class="pl-en">End</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;f&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;g&#39;</span>), <span class="pl-en">End</span>))))) <span class="pl-k">===</span> <span class="pl-s"><span class="pl-pds">&quot;</span>a(b(d,e),c(,f(g,)))<span class="pl-pds">&quot;</span></span></td>
      </tr>
      <tr>
        <td id="L339" class="blob-num js-line-number" data-line-number="339"></td>
        <td id="LC339" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L340" class="blob-num js-line-number" data-line-number="340"></td>
        <td id="LC340" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p67_backward</span>(<span class="pl-v">str</span>: <span class="pl-k">String</span>)<span class="pl-k">:</span> <span class="pl-en">Tree</span>[<span class="pl-k">Char</span>] <span class="pl-k">=</span> p67_backward(str.toList)</td>
      </tr>
      <tr>
        <td id="L341" class="blob-num js-line-number" data-line-number="341"></td>
        <td id="LC341" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p67_backward</span>(<span class="pl-v">str</span>: <span class="pl-en">List</span>[<span class="pl-k">Char</span>])<span class="pl-k">:</span> <span class="pl-en">Tree</span>[<span class="pl-k">Char</span>] <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L342" class="blob-num js-line-number" data-line-number="342"></td>
        <td id="LC342" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">findBracket</span>(<span class="pl-v">str</span>: <span class="pl-en">List</span>[<span class="pl-k">Char</span>], <span class="pl-v">curNesting</span>: <span class="pl-k">Int</span> <span class="pl-k">=</span> <span class="pl-c1">1</span>, <span class="pl-v">collectedStr</span>: <span class="pl-en">List</span>[<span class="pl-k">Char</span>] <span class="pl-k">=</span> <span class="pl-c1">Nil</span>, <span class="pl-v">leftStr</span>: <span class="pl-en">List</span>[<span class="pl-k">Char</span>] <span class="pl-k">=</span> <span class="pl-c1">Nil</span>)<span class="pl-k">:</span> (<span class="pl-en">List</span>[<span class="pl-k">Char</span>], <span class="pl-en">List</span>[<span class="pl-k">Char</span>]) <span class="pl-k">=</span> (str, curNesting) <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L343" class="blob-num js-line-number" data-line-number="343"></td>
        <td id="LC343" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> (_, <span class="pl-c1">0</span>) <span class="pl-k">=&gt;</span> (leftStr.reverse, collectedStr.reverse)</td>
      </tr>
      <tr>
        <td id="L344" class="blob-num js-line-number" data-line-number="344"></td>
        <td id="LC344" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> (<span class="pl-c1">&#39;,&#39;</span> <span class="pl-k">::</span> tail, <span class="pl-c1">1</span>) <span class="pl-k">=&gt;</span> findBracket(tail, curNesting, <span class="pl-c1">Nil</span>, collectedStr)</td>
      </tr>
      <tr>
        <td id="L345" class="blob-num js-line-number" data-line-number="345"></td>
        <td id="LC345" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> (<span class="pl-c1">&#39;,&#39;</span> <span class="pl-k">::</span> tail, _) <span class="pl-k">=&gt;</span> findBracket(tail, curNesting, <span class="pl-c1">&#39;,&#39;</span> <span class="pl-k">::</span> collectedStr, leftStr)</td>
      </tr>
      <tr>
        <td id="L346" class="blob-num js-line-number" data-line-number="346"></td>
        <td id="LC346" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> (<span class="pl-c1">&#39;(&#39;</span> <span class="pl-k">::</span> tail, _) <span class="pl-k">=&gt;</span> findBracket(tail, curNesting <span class="pl-k">+</span> <span class="pl-c1">1</span>, <span class="pl-c1">&#39;(&#39;</span> <span class="pl-k">::</span> collectedStr, leftStr)</td>
      </tr>
      <tr>
        <td id="L347" class="blob-num js-line-number" data-line-number="347"></td>
        <td id="LC347" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> (<span class="pl-c1">&#39;)&#39;</span> <span class="pl-k">::</span> tail, <span class="pl-c1">1</span>) <span class="pl-k">=&gt;</span> findBracket(tail, curNesting <span class="pl-k">-</span> <span class="pl-c1">1</span>, collectedStr, leftStr)</td>
      </tr>
      <tr>
        <td id="L348" class="blob-num js-line-number" data-line-number="348"></td>
        <td id="LC348" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> (<span class="pl-c1">&#39;)&#39;</span> <span class="pl-k">::</span> tail, _) <span class="pl-k">=&gt;</span> findBracket(tail, curNesting <span class="pl-k">-</span> <span class="pl-c1">1</span>, <span class="pl-c1">&#39;)&#39;</span> <span class="pl-k">::</span> collectedStr, leftStr)</td>
      </tr>
      <tr>
        <td id="L349" class="blob-num js-line-number" data-line-number="349"></td>
        <td id="LC349" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> (head <span class="pl-k">::</span> tail, _) <span class="pl-k">=&gt;</span> findBracket(tail, curNesting, head <span class="pl-k">::</span> collectedStr, leftStr)</td>
      </tr>
      <tr>
        <td id="L350" class="blob-num js-line-number" data-line-number="350"></td>
        <td id="LC350" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L351" class="blob-num js-line-number" data-line-number="351"></td>
        <td id="LC351" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L352" class="blob-num js-line-number" data-line-number="352"></td>
        <td id="LC352" class="blob-code blob-code-inner js-file-line">    str <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L353" class="blob-num js-line-number" data-line-number="353"></td>
        <td id="LC353" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-c1">Nil</span> <span class="pl-k">=&gt;</span> <span class="pl-en">End</span></td>
      </tr>
      <tr>
        <td id="L354" class="blob-num js-line-number" data-line-number="354"></td>
        <td id="LC354" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> value <span class="pl-k">::</span> <span class="pl-c1">Nil</span> <span class="pl-k">=&gt;</span> <span class="pl-en">Node</span>(value)</td>
      </tr>
      <tr>
        <td id="L355" class="blob-num js-line-number" data-line-number="355"></td>
        <td id="LC355" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> value <span class="pl-k">::</span> <span class="pl-c1">&#39;(&#39;</span> <span class="pl-k">::</span> tail <span class="pl-k">=&gt;</span></td>
      </tr>
      <tr>
        <td id="L356" class="blob-num js-line-number" data-line-number="356"></td>
        <td id="LC356" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">val</span> (left, right) <span class="pl-k">=</span> findBracket(tail)    <span class="pl-c">// lookup</span></td>
      </tr>
      <tr>
        <td id="L357" class="blob-num js-line-number" data-line-number="357"></td>
        <td id="LC357" class="blob-code blob-code-inner js-file-line">        <span class="pl-en">Node</span>(value, p67_backward(left), p67_backward(right))</td>
      </tr>
      <tr>
        <td id="L358" class="blob-num js-line-number" data-line-number="358"></td>
        <td id="LC358" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L359" class="blob-num js-line-number" data-line-number="359"></td>
        <td id="LC359" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L360" class="blob-num js-line-number" data-line-number="360"></td>
        <td id="LC360" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L361" class="blob-num js-line-number" data-line-number="361"></td>
        <td id="LC361" class="blob-code blob-code-inner js-file-line">  out(p67_backward(<span class="pl-s"><span class="pl-pds">&quot;</span>a(b(d,e),c(,f(g,)))<span class="pl-pds">&quot;</span></span>)) <span class="pl-k">===</span> <span class="pl-en">Node</span>(<span class="pl-c1">&#39;a&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;b&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;d&#39;</span>), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;e&#39;</span>)), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;c&#39;</span>, <span class="pl-en">End</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;f&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;g&#39;</span>), <span class="pl-en">End</span>)))</td>
      </tr>
      <tr>
        <td id="L362" class="blob-num js-line-number" data-line-number="362"></td>
        <td id="LC362" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L363" class="blob-num js-line-number" data-line-number="363"></td>
        <td id="LC363" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">--------------</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>P68. Preorder and inorder sequences of binary trees.<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L364" class="blob-num js-line-number" data-line-number="364"></td>
        <td id="LC364" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p68_preorder</span>(<span class="pl-v">tree</span>: <span class="pl-en">Tree</span>[<span class="pl-k">Char</span>])<span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-k">Char</span>] <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L365" class="blob-num js-line-number" data-line-number="365"></td>
        <td id="LC365" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">inner</span>(<span class="pl-v">tree</span>: <span class="pl-en">Tree</span>[<span class="pl-k">Char</span>], <span class="pl-v">lst</span>: <span class="pl-en">List</span>[<span class="pl-k">Char</span>])<span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-k">Char</span>] <span class="pl-k">=</span></td>
      </tr>
      <tr>
        <td id="L366" class="blob-num js-line-number" data-line-number="366"></td>
        <td id="LC366" class="blob-code blob-code-inner js-file-line">      tree <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L367" class="blob-num js-line-number" data-line-number="367"></td>
        <td id="LC367" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> <span class="pl-en">End</span> <span class="pl-k">=&gt;</span> lst</td>
      </tr>
      <tr>
        <td id="L368" class="blob-num js-line-number" data-line-number="368"></td>
        <td id="LC368" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> <span class="pl-en">Node</span>(v, l, r) <span class="pl-k">=&gt;</span> {</td>
      </tr>
      <tr>
        <td id="L369" class="blob-num js-line-number" data-line-number="369"></td>
        <td id="LC369" class="blob-code blob-code-inner js-file-line">          <span class="pl-k">val</span> <span class="pl-en">result</span> <span class="pl-k">=</span> inner(l, v <span class="pl-k">::</span> lst)</td>
      </tr>
      <tr>
        <td id="L370" class="blob-num js-line-number" data-line-number="370"></td>
        <td id="LC370" class="blob-code blob-code-inner js-file-line">          inner(r, result)</td>
      </tr>
      <tr>
        <td id="L371" class="blob-num js-line-number" data-line-number="371"></td>
        <td id="LC371" class="blob-code blob-code-inner js-file-line">        }</td>
      </tr>
      <tr>
        <td id="L372" class="blob-num js-line-number" data-line-number="372"></td>
        <td id="LC372" class="blob-code blob-code-inner js-file-line">      }</td>
      </tr>
      <tr>
        <td id="L373" class="blob-num js-line-number" data-line-number="373"></td>
        <td id="LC373" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L374" class="blob-num js-line-number" data-line-number="374"></td>
        <td id="LC374" class="blob-code blob-code-inner js-file-line">    inner(tree, <span class="pl-c1">Nil</span>).reverse</td>
      </tr>
      <tr>
        <td id="L375" class="blob-num js-line-number" data-line-number="375"></td>
        <td id="LC375" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L376" class="blob-num js-line-number" data-line-number="376"></td>
        <td id="LC376" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L377" class="blob-num js-line-number" data-line-number="377"></td>
        <td id="LC377" class="blob-code blob-code-inner js-file-line">  out(p68_preorder(<span class="pl-en">Node</span>(<span class="pl-c1">&#39;a&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;b&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;d&#39;</span>), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;e&#39;</span>)), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;c&#39;</span>, <span class="pl-en">End</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;f&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;g&#39;</span>), <span class="pl-en">End</span>))))) <span class="pl-k">===</span> <span class="pl-en">List</span>(<span class="pl-c1">&#39;a&#39;</span>, <span class="pl-c1">&#39;b&#39;</span>, <span class="pl-c1">&#39;d&#39;</span>, <span class="pl-c1">&#39;e&#39;</span>, <span class="pl-c1">&#39;c&#39;</span>, <span class="pl-c1">&#39;f&#39;</span>, <span class="pl-c1">&#39;g&#39;</span>)</td>
      </tr>
      <tr>
        <td id="L378" class="blob-num js-line-number" data-line-number="378"></td>
        <td id="LC378" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L379" class="blob-num js-line-number" data-line-number="379"></td>
        <td id="LC379" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p68_inorder</span>(<span class="pl-v">tree</span>: <span class="pl-en">Tree</span>[<span class="pl-k">Char</span>])<span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-k">Char</span>] <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L380" class="blob-num js-line-number" data-line-number="380"></td>
        <td id="LC380" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">inner</span>(<span class="pl-v">tree</span>: <span class="pl-en">Tree</span>[<span class="pl-k">Char</span>], <span class="pl-v">lst</span>: <span class="pl-en">List</span>[<span class="pl-k">Char</span>])<span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-k">Char</span>] <span class="pl-k">=</span></td>
      </tr>
      <tr>
        <td id="L381" class="blob-num js-line-number" data-line-number="381"></td>
        <td id="LC381" class="blob-code blob-code-inner js-file-line">      tree <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L382" class="blob-num js-line-number" data-line-number="382"></td>
        <td id="LC382" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> <span class="pl-en">End</span> <span class="pl-k">=&gt;</span> lst</td>
      </tr>
      <tr>
        <td id="L383" class="blob-num js-line-number" data-line-number="383"></td>
        <td id="LC383" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> <span class="pl-en">Node</span>(v, l, r) <span class="pl-k">=&gt;</span> {</td>
      </tr>
      <tr>
        <td id="L384" class="blob-num js-line-number" data-line-number="384"></td>
        <td id="LC384" class="blob-code blob-code-inner js-file-line">          <span class="pl-k">val</span> <span class="pl-en">result</span> <span class="pl-k">=</span> v <span class="pl-k">::</span> inner(l, lst)</td>
      </tr>
      <tr>
        <td id="L385" class="blob-num js-line-number" data-line-number="385"></td>
        <td id="LC385" class="blob-code blob-code-inner js-file-line">          inner(r, result)</td>
      </tr>
      <tr>
        <td id="L386" class="blob-num js-line-number" data-line-number="386"></td>
        <td id="LC386" class="blob-code blob-code-inner js-file-line">        }</td>
      </tr>
      <tr>
        <td id="L387" class="blob-num js-line-number" data-line-number="387"></td>
        <td id="LC387" class="blob-code blob-code-inner js-file-line">      }</td>
      </tr>
      <tr>
        <td id="L388" class="blob-num js-line-number" data-line-number="388"></td>
        <td id="LC388" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L389" class="blob-num js-line-number" data-line-number="389"></td>
        <td id="LC389" class="blob-code blob-code-inner js-file-line">    inner(tree, <span class="pl-c1">Nil</span>).reverse</td>
      </tr>
      <tr>
        <td id="L390" class="blob-num js-line-number" data-line-number="390"></td>
        <td id="LC390" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L391" class="blob-num js-line-number" data-line-number="391"></td>
        <td id="LC391" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L392" class="blob-num js-line-number" data-line-number="392"></td>
        <td id="LC392" class="blob-code blob-code-inner js-file-line">  out(p68_inorder(<span class="pl-en">Node</span>(<span class="pl-c1">&#39;a&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;b&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;d&#39;</span>), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;e&#39;</span>)), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;c&#39;</span>, <span class="pl-en">End</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;f&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;g&#39;</span>), <span class="pl-en">End</span>))))) <span class="pl-k">===</span> <span class="pl-en">List</span>(<span class="pl-c1">&#39;d&#39;</span>, <span class="pl-c1">&#39;b&#39;</span>, <span class="pl-c1">&#39;e&#39;</span>, <span class="pl-c1">&#39;a&#39;</span>, <span class="pl-c1">&#39;c&#39;</span>, <span class="pl-c1">&#39;g&#39;</span>, <span class="pl-c1">&#39;f&#39;</span>)</td>
      </tr>
      <tr>
        <td id="L393" class="blob-num js-line-number" data-line-number="393"></td>
        <td id="LC393" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L394" class="blob-num js-line-number" data-line-number="394"></td>
        <td id="LC394" class="blob-code blob-code-inner js-file-line">  <span class="pl-c">// This doesn&#39;t work</span></td>
      </tr>
      <tr>
        <td id="L395" class="blob-num js-line-number" data-line-number="395"></td>
        <td id="LC395" class="blob-code blob-code-inner js-file-line"><span class="pl-c">//</span></td>
      </tr>
      <tr>
        <td id="L396" class="blob-num js-line-number" data-line-number="396"></td>
        <td id="LC396" class="blob-code blob-code-inner js-file-line"><span class="pl-c">//  def p68_preInTree(preOrder: List[Char], inOrder: List[Char]): Tree[Char] = preOrder match {</span></td>
      </tr>
      <tr>
        <td id="L397" class="blob-num js-line-number" data-line-number="397"></td>
        <td id="LC397" class="blob-code blob-code-inner js-file-line"><span class="pl-c">//    case Nil =&gt; End</span></td>
      </tr>
      <tr>
        <td id="L398" class="blob-num js-line-number" data-line-number="398"></td>
        <td id="LC398" class="blob-code blob-code-inner js-file-line"><span class="pl-c">//    case v :: preTail =&gt; {</span></td>
      </tr>
      <tr>
        <td id="L399" class="blob-num js-line-number" data-line-number="399"></td>
        <td id="LC399" class="blob-code blob-code-inner js-file-line"><span class="pl-c">//      val (leftIn, rightIn) = inOrder.span(_ != v)</span></td>
      </tr>
      <tr>
        <td id="L400" class="blob-num js-line-number" data-line-number="400"></td>
        <td id="LC400" class="blob-code blob-code-inner js-file-line"><span class="pl-c">//      Node(v, p68_preInTree(preTail.take(leftIn.length), leftIn),</span></td>
      </tr>
      <tr>
        <td id="L401" class="blob-num js-line-number" data-line-number="401"></td>
        <td id="LC401" class="blob-code blob-code-inner js-file-line"><span class="pl-c">//        p68_preInTree(preTail.drop(leftIn.length), rightIn))</span></td>
      </tr>
      <tr>
        <td id="L402" class="blob-num js-line-number" data-line-number="402"></td>
        <td id="LC402" class="blob-code blob-code-inner js-file-line"><span class="pl-c">//    }</span></td>
      </tr>
      <tr>
        <td id="L403" class="blob-num js-line-number" data-line-number="403"></td>
        <td id="LC403" class="blob-code blob-code-inner js-file-line"><span class="pl-c">//  }</span></td>
      </tr>
      <tr>
        <td id="L404" class="blob-num js-line-number" data-line-number="404"></td>
        <td id="LC404" class="blob-code blob-code-inner js-file-line"><span class="pl-c">//</span></td>
      </tr>
      <tr>
        <td id="L405" class="blob-num js-line-number" data-line-number="405"></td>
        <td id="LC405" class="blob-code blob-code-inner js-file-line"><span class="pl-c">//  out(p68_preInTree(List(&#39;a&#39;, &#39;b&#39;, &#39;d&#39;, &#39;e&#39;, &#39;c&#39;, &#39;f&#39;, &#39;g&#39;), List(&#39;d&#39;, &#39;b&#39;, &#39;e&#39;, &#39;a&#39;, &#39;c&#39;, &#39;g&#39;, &#39;f&#39;))) ===</span></td>
      </tr>
      <tr>
        <td id="L406" class="blob-num js-line-number" data-line-number="406"></td>
        <td id="LC406" class="blob-code blob-code-inner js-file-line"><span class="pl-c">//    Node(&#39;a&#39;, Node(&#39;b&#39;, Node(&#39;d&#39;), Node(&#39;e&#39;)), Node(&#39;c&#39;, End, Node(&#39;f&#39;, Node(&#39;g&#39;), End)))</span></td>
      </tr>
      <tr>
        <td id="L407" class="blob-num js-line-number" data-line-number="407"></td>
        <td id="LC407" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">--------------</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>P69. Dotstring representation of binary trees.<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L408" class="blob-num js-line-number" data-line-number="408"></td>
        <td id="LC408" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L409" class="blob-num js-line-number" data-line-number="409"></td>
        <td id="LC409" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p69</span>(<span class="pl-v">tree</span>: <span class="pl-en">Tree</span>[<span class="pl-k">Char</span>])<span class="pl-k">:</span> <span class="pl-k">String</span> <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L410" class="blob-num js-line-number" data-line-number="410"></td>
        <td id="LC410" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">inner</span>(<span class="pl-v">tree</span>: <span class="pl-en">Tree</span>[<span class="pl-k">Char</span>])<span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-k">Char</span>] <span class="pl-k">=</span> tree <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L411" class="blob-num js-line-number" data-line-number="411"></td>
        <td id="LC411" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-en">End</span> <span class="pl-k">=&gt;</span> <span class="pl-c1">&#39;.&#39;</span> <span class="pl-k">::</span> <span class="pl-c1">Nil</span></td>
      </tr>
      <tr>
        <td id="L412" class="blob-num js-line-number" data-line-number="412"></td>
        <td id="LC412" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-en">Node</span>(value, l, r) <span class="pl-k">=&gt;</span> value <span class="pl-k">::</span> inner(l) <span class="pl-k">:::</span> inner(r)</td>
      </tr>
      <tr>
        <td id="L413" class="blob-num js-line-number" data-line-number="413"></td>
        <td id="LC413" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L414" class="blob-num js-line-number" data-line-number="414"></td>
        <td id="LC414" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L415" class="blob-num js-line-number" data-line-number="415"></td>
        <td id="LC415" class="blob-code blob-code-inner js-file-line">    inner(tree).mkString</td>
      </tr>
      <tr>
        <td id="L416" class="blob-num js-line-number" data-line-number="416"></td>
        <td id="LC416" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L417" class="blob-num js-line-number" data-line-number="417"></td>
        <td id="LC417" class="blob-code blob-code-inner js-file-line">  out(p69(<span class="pl-en">Node</span>(<span class="pl-c1">&#39;a&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;b&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;d&#39;</span>), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;e&#39;</span>)), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;c&#39;</span>, <span class="pl-en">End</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;f&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;g&#39;</span>), <span class="pl-en">End</span>))))) <span class="pl-k">===</span> <span class="pl-s"><span class="pl-pds">&quot;</span>abd..e..c.fg...<span class="pl-pds">&quot;</span></span></td>
      </tr>
      <tr>
        <td id="L418" class="blob-num js-line-number" data-line-number="418"></td>
        <td id="LC418" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L419" class="blob-num js-line-number" data-line-number="419"></td>
        <td id="LC419" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p69_back</span>(<span class="pl-v">lst</span>: <span class="pl-k">String</span>)<span class="pl-k">:</span> <span class="pl-en">Tree</span>[<span class="pl-k">Char</span>] <span class="pl-k">=</span> p69_back(lst.toList)</td>
      </tr>
      <tr>
        <td id="L420" class="blob-num js-line-number" data-line-number="420"></td>
        <td id="LC420" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L421" class="blob-num js-line-number" data-line-number="421"></td>
        <td id="LC421" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p69_back</span>(<span class="pl-v">lst</span>: <span class="pl-en">List</span>[<span class="pl-k">Char</span>])<span class="pl-k">:</span> <span class="pl-en">Tree</span>[<span class="pl-k">Char</span>] <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L422" class="blob-num js-line-number" data-line-number="422"></td>
        <td id="LC422" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">inner</span>(<span class="pl-v">lst</span>: <span class="pl-en">List</span>[<span class="pl-k">Char</span>])<span class="pl-k">:</span> (<span class="pl-en">Tree</span>[<span class="pl-k">Char</span>], <span class="pl-en">List</span>[<span class="pl-k">Char</span>]) <span class="pl-k">=</span> lst <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L423" class="blob-num js-line-number" data-line-number="423"></td>
        <td id="LC423" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-c1">&#39;.&#39;</span> <span class="pl-k">::</span> tail <span class="pl-k">=&gt;</span> (<span class="pl-en">End</span>, tail)</td>
      </tr>
      <tr>
        <td id="L424" class="blob-num js-line-number" data-line-number="424"></td>
        <td id="LC424" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> value <span class="pl-k">::</span> <span class="pl-c1">&#39;.&#39;</span> <span class="pl-k">::</span> <span class="pl-c1">&#39;.&#39;</span> <span class="pl-k">::</span> tail <span class="pl-k">=&gt;</span> (<span class="pl-en">Node</span>(value), tail)</td>
      </tr>
      <tr>
        <td id="L425" class="blob-num js-line-number" data-line-number="425"></td>
        <td id="LC425" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> value <span class="pl-k">::</span> tail <span class="pl-k">=&gt;</span></td>
      </tr>
      <tr>
        <td id="L426" class="blob-num js-line-number" data-line-number="426"></td>
        <td id="LC426" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">val</span> (lTree, rest) <span class="pl-k">=</span> inner(tail)</td>
      </tr>
      <tr>
        <td id="L427" class="blob-num js-line-number" data-line-number="427"></td>
        <td id="LC427" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">val</span> (rTree, restLast) <span class="pl-k">=</span> inner(rest)</td>
      </tr>
      <tr>
        <td id="L428" class="blob-num js-line-number" data-line-number="428"></td>
        <td id="LC428" class="blob-code blob-code-inner js-file-line">        (<span class="pl-en">Node</span>(value, lTree, rTree), restLast)</td>
      </tr>
      <tr>
        <td id="L429" class="blob-num js-line-number" data-line-number="429"></td>
        <td id="LC429" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L430" class="blob-num js-line-number" data-line-number="430"></td>
        <td id="LC430" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L431" class="blob-num js-line-number" data-line-number="431"></td>
        <td id="LC431" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">val</span> (tree, _) <span class="pl-k">=</span> inner(lst)</td>
      </tr>
      <tr>
        <td id="L432" class="blob-num js-line-number" data-line-number="432"></td>
        <td id="LC432" class="blob-code blob-code-inner js-file-line">    tree</td>
      </tr>
      <tr>
        <td id="L433" class="blob-num js-line-number" data-line-number="433"></td>
        <td id="LC433" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L434" class="blob-num js-line-number" data-line-number="434"></td>
        <td id="LC434" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L435" class="blob-num js-line-number" data-line-number="435"></td>
        <td id="LC435" class="blob-code blob-code-inner js-file-line">  out(p69_back(<span class="pl-s"><span class="pl-pds">&quot;</span>abd..e..c.fg...<span class="pl-pds">&quot;</span></span>)) <span class="pl-k">===</span> <span class="pl-en">Node</span>(<span class="pl-c1">&#39;a&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;b&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;d&#39;</span>), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;e&#39;</span>)), <span class="pl-en">Node</span>(<span class="pl-c1">&#39;c&#39;</span>, <span class="pl-en">End</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;f&#39;</span>, <span class="pl-en">Node</span>(<span class="pl-c1">&#39;g&#39;</span>), <span class="pl-en">End</span>)))</td>
      </tr>
      <tr>
        <td id="L436" class="blob-num js-line-number" data-line-number="436"></td>
        <td id="LC436" class="blob-code blob-code-inner js-file-line">}</td>
      </tr>
</table>

  </div>

</div>

<a href="#jump-to-line" rel="facebox[.linejump]" data-hotkey="l" style="display:none">Jump to Line</a>
<div id="jump-to-line" style="display:none">
  <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="" class="js-jump-to-line-form" method="get"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /></div>
    <input class="linejump-input js-jump-to-line-field" type="text" placeholder="Jump to line&hellip;" aria-label="Jump to line" autofocus>
    <button type="submit" class="btn">Go</button>
</form></div>

  </div>
  <div class="modal-backdrop"></div>
</div>

    </div>
  </div>

    </div>

        <div class="container">
  <div class="site-footer" role="contentinfo">
    <ul class="site-footer-links right">
        <li><a href="https://status.github.com/" data-ga-click="Footer, go to status, text:status">Status</a></li>
      <li><a href="https://developer.github.com" data-ga-click="Footer, go to api, text:api">API</a></li>
      <li><a href="https://training.github.com" data-ga-click="Footer, go to training, text:training">Training</a></li>
      <li><a href="https://shop.github.com" data-ga-click="Footer, go to shop, text:shop">Shop</a></li>
        <li><a href="https://github.com/blog" data-ga-click="Footer, go to blog, text:blog">Blog</a></li>
        <li><a href="https://github.com/about" data-ga-click="Footer, go to about, text:about">About</a></li>
        <li><a href="https://github.com/pricing" data-ga-click="Footer, go to pricing, text:pricing">Pricing</a></li>

    </ul>

    <a href="https://github.com" aria-label="Homepage">
      <span class="mega-octicon octicon-mark-github" title="GitHub"></span>
</a>
    <ul class="site-footer-links">
      <li>&copy; 2015 <span title="0.08822s from github-fe131-cp1-prd.iad.github.net">GitHub</span>, Inc.</li>
        <li><a href="https://github.com/site/terms" data-ga-click="Footer, go to terms, text:terms">Terms</a></li>
        <li><a href="https://github.com/site/privacy" data-ga-click="Footer, go to privacy, text:privacy">Privacy</a></li>
        <li><a href="https://github.com/security" data-ga-click="Footer, go to security, text:security">Security</a></li>
        <li><a href="https://github.com/contact" data-ga-click="Footer, go to contact, text:contact">Contact</a></li>
        <li><a href="https://help.github.com" data-ga-click="Footer, go to help, text:help">Help</a></li>
    </ul>
  </div>
</div>



    
    
    

    <div id="ajax-error-message" class="flash flash-error">
      <span class="octicon octicon-alert"></span>
      <button type="button" class="flash-close js-flash-close js-ajax-error-dismiss" aria-label="Dismiss error">
        <span class="octicon octicon-x"></span>
      </button>
      Something went wrong with that request. Please try again.
    </div>


      <script crossorigin="anonymous" integrity="sha256-t8lSPZPmzQI1oKi30aaR95CdODTNnJyqexZ0ulCLZEw=" src="https://assets-cdn.github.com/assets/frameworks-b7c9523d93e6cd0235a0a8b7d1a691f7909d3834cd9c9caa7b1674ba508b644c.js"></script>
      <script async="async" crossorigin="anonymous" integrity="sha256-C6eaSq1zApeOz5oXqx8DDXhOSRxeMpf/V/r2lSbEKaU=" src="https://assets-cdn.github.com/assets/github-0ba79a4aad7302978ecf9a17ab1f030d784e491c5e3297ff57faf69526c429a5.js"></script>
      
      
      
    <div class="js-stale-session-flash stale-session-flash flash flash-warn flash-banner hidden">
      <span class="octicon octicon-alert"></span>
      <span class="signed-in-tab-flash">You signed in with another tab or window. <a href="">Reload</a> to refresh your session.</span>
      <span class="signed-out-tab-flash">You signed out in another tab or window. <a href="">Reload</a> to refresh your session.</span>
    </div>
  </body>
</html>

